package com.LabaLaba.service;

import com.LabaLaba.entity.*;
import com.LabaLaba.repository.CustomerRepository;
import com.LabaLaba.repository.PaymentDetailRepository;
import com.LabaLaba.repository.PaymentRepository;
import com.LabaLaba.repository.SupplierRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by rien on 12/17/16.
 */
@Service
public class PaymentService {
    @Autowired
    private CartService cartService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private PaymentDetailRepository paymentDetailRepository;

    public Payment confirmPayment(Long paymentId) {
        if (paymentId == null) {
            return null;
        }

        Payment paymentToBeConfirmed = paymentRepository.findOne(paymentId);

        if (paymentToBeConfirmed == null) {
            return null;
        }

        paymentToBeConfirmed.setPaid(true);

        paymentRepository.save(paymentToBeConfirmed);

        return paymentToBeConfirmed;
    }

    public Collection<Payment> createPayment(Long ownerId) {
        if(ownerId == null) {
            return null;
        }
        Customer owner = customerRepository.findOne(ownerId);

        List<CartItem> cart = new ArrayList<>(cartService.getCartByCustomer(ownerId));
        Map<Long, List<CartItem>> separatedItem = separateItemBySupplier(cart);
        List<Payment> payments = generatePaymentsFromSeparatedItem(separatedItem, owner);

        cartService.cleanCustomerCart(ownerId);

        return saveNewPayment(payments);
    }

    private Collection<Payment> saveNewPayment(List<Payment> payments) {
        for(Payment payment : payments) {
            paymentRepository.save(payment);
            paymentDetailRepository.save(payment.getDetails());
        }
        return payments;
    }

    public Collection<Payment> getPaymentByCustomer(Long customerId) {
        if(customerId == null) {
            return null;
        }

        Customer customer = customerRepository.findOne(customerId);
        if(customer == null) {
            return null;
        }

        return paymentRepository.findByCustomerOrderByCreationDateDesc(customer);
    }

    public Collection<Payment> getPaymentBySupplier(Long supplierId) {
        if(supplierId == null) {
            return null;
        }

        Supplier supplier = supplierRepository.findOne(supplierId);
        if(supplier == null) {
            return null;
        }

        return paymentRepository.findBySupplierOrderByCreationDateDesc(supplier);
    }


    private List<Payment> generatePaymentsFromSeparatedItem(Map<Long, List<CartItem>> separatedItem, Customer owner) {
        List<Payment> result = new ArrayList<>();
        for(Map.Entry<Long, List<CartItem>> entry : separatedItem.entrySet()) {

            Payment payment = generatePayment(entry.getValue(), owner);
            result.add(payment);
        }

        return result;
    }

    private Map<Long, List<CartItem>> separateItemBySupplier(List<CartItem> cart) {
        Map<Long, List<CartItem>> result = new HashMap();

        for(CartItem item : cart) {
            Long supplierId = item.getProduct().getSupplier().getId();

            if(!result.containsKey(supplierId)) {
                result.put(supplierId, new ArrayList<>());
            }
            result.get(supplierId).add(item);
        }

        return result;
    }

    private Payment generatePayment(List<CartItem> cartItems, Customer owner) {
        Payment result = new Payment();
        List<PaymentDetail> resultDetail = new ArrayList<>();
        Supplier supplier = cartItems.get(0).getProduct().getSupplier();

        for(CartItem item : cartItems) {
            PaymentDetail detail = new PaymentDetail();

            detail.setQuantity(item.getQuantity());
            detail.setHeader(result);
            detail.setProduct(item.getProduct());

            //To-do: treshold
            detail.setPrice(item.getProduct().getPrice());
            resultDetail.add(detail);
        }

        result.setCreationDate(new DateTime());
        result.setCustomer(owner);
        result.setDetails(resultDetail);
        result.setSupplier(supplier);
        result.setPaid(false);
        return result;
    }

}
