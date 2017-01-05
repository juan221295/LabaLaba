package com.LabaLaba.service;

import com.LabaLaba.entity.CartItem;
import com.LabaLaba.entity.Customer;
import com.LabaLaba.entity.Product;
import com.LabaLaba.repository.CartRepository;
import com.LabaLaba.repository.CustomerRepository;
import com.LabaLaba.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by rien on 1/3/17.
 * TO DO: DEFENSIVE
 */
@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    public CartItem addToCart(Long ownerId, Long productId, Integer quantity) {
        if(ownerId == null || productId == null || quantity == null) {
            return null;
        }

        Customer owner = customerRepository.findOne(ownerId);
        Product product = productRepository.findById(productId);

        CartItem cartItem = new CartItem(owner, product, quantity);

        return cartRepository.save(cartItem);
    }

    public void deleteFromCart(Long cartId) {
        cartRepository.delete(cartId);
    }

    public Collection<CartItem> getCartByOwner(Long ownerId) {
        if(ownerId == null) {
            return null;
        }
        Customer owner = customerRepository.findOne(ownerId);

        return cartRepository.findByOwner(owner);
    }
}
