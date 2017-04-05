/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.babyshop.model;

import com.j.babyshop.entity.Product;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author FIA
 */
public class Cart {

    private final HashMap<Product, Integer> cart = new HashMap<>();

    public Cart() {

    }

    public void putInto(Product p) {
        Integer amount = cart.get(p);
        cart.put(p, amount == null ? 1 : amount + 1);
    }

    public HashMap<Product, Integer> getProducts() {
        return cart;
    }

    public float getBillSumpUp() {
        float res = 0;
        Set<Product> keys = cart.keySet();
        for (Product p : keys) {
            res += p.getPrice();
        }
        return res;
    }
}
