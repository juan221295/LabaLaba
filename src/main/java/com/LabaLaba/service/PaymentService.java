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

        if(owner == null) {
            return null;
        }
        if(owner.getAddress() == null) {
            return null;
        }

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

        return paymentRepository.findByCustomerIdOrderByCreationDateDesc(customer.getId());
    }

    public Collection<Payment> getPaymentBySupplier(Long supplierId) {
        if(supplierId == null) {
            return null;
        }

        Supplier supplier = supplierRepository.findOne(supplierId);
        if(supplier == null) {
            return null;
        }

        return paymentRepository.findBySupplierIdOrderByCreationDateDesc(supplier.getId());
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
        long totalPriceBuffer = 0;

        for(CartItem itemInCart : cartItems) {
            PaymentDetail detail = new PaymentDetail();

            detail.setQuantity(itemInCart.getQuantity());
            detail.setHeader(result);

            Product productInCart = itemInCart.getProduct();
            detail.setProductId(productInCart.getId());
            detail.setProductName(productInCart.getName());
            detail.setProductImagePath(productInCart.getImagePath());


            detail.setPrice(itemInCart.getPrice() * itemInCart.getQuantity());
            totalPriceBuffer = itemInCart.getPrice() * itemInCart.getQuantity();
            resultDetail.add(detail);
        }

        result.setCreationDate(new DateTime());
        result.setCustomerId(owner.getId());
        result.setCustomerName(owner.getName());
        result.setSupplierId(supplier.getId());
        result.setPurchaseAddress(owner.getAddress());
        result.setSupplierName(supplier.getName());
        result.setDetails(resultDetail);
        result.setPaid(false);
        result.setTotalPrice(totalPriceBuffer);

        return result;
    }

}
