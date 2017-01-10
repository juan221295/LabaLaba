package com.LabaLaba.service;

import com.LabaLaba.entity.*;
import com.LabaLaba.repository.CustomerRepository;
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

    public Collection<Payment> createPayment(Long ownerId) {
        if(ownerId == null) {
            return null;
        }
        Customer owner = customerRepository.findOne(ownerId);

        ArrayList<CartItem> cart = new ArrayList<>(cartService.getCartByCustomer(ownerId));
        Map<Long, List<CartItem>> separatedItem = separateItemBySupplier(cart);
        List<Payment> payments = generatePaymentsFromSeparatedItem(separatedItem, owner);

        return paymentRepository.save(payments);
    }

    public Collection<Payment> getPaymentByCustomer(Long customerId) {
        if(customerId == null) {
            return null;
        }

        Customer customer = customerRepository.findOne(customerId);
        if(customer == null) {
            return null;
        }

        return paymentRepository.findByCustomer(customer);
    }

    public Collection<Payment> getPaymentBySupplier(Long supplierId) {
        if(supplierId == null) {
            return null;
        }

        Supplier supplier = supplierRepository.findOne(supplierId);
        if(supplier == null) {
            return null;
        }

        return paymentRepository.findBySupplier(supplier);
    }


    private List<Payment> generatePaymentsFromSeparatedItem(Map<Long, List<CartItem>> separatedItem, Customer owner) {
        List<Payment> result = new ArrayList<>();
        for(Map.Entry<Long, List<CartItem>> entry : separatedItem.entrySet()) {

            Payment payment = generatePayment(entry.getValue(), owner);
            result.add(payment);
        }

        return result;
    }

    private Map<Long, List<CartItem>> separateItemBySupplier(ArrayList<CartItem> cart) {
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
            detail.setPrice(item.getProduct().getPrice());
            detail.setProduct(item.getProduct());

            resultDetail.add(detail);
        }

        result.setCreationDate(new DateTime());
        result.setCustomer(owner);
        result.setDetails(resultDetail);
        result.setSupplier(supplier);

        return result;
    }

}
