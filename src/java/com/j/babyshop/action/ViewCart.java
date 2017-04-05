/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.babyshop.action;

import com.j.babyshop.entity.Product;
import com.j.babyshop.model.Cart;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;

/**
 *
 * @author FIA
 */
public class ViewCart extends ActionSupport {
     @Override
    public String execute() throws Exception {
        return super.execute(); //To change body of generated methods, choose Tools | Templates.
    }
    private HashMap<Product,Integer> products;
    private float totalAmount;

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public float getTotalAmount() {
        return totalAmount;
    }
    private String getData(){
        Cart cart=(Cart)ActionContext.getContext().getSession().get("cart");
        if(cart.getProducts().size()==0)
            return ERROR;
        products=cart.getProducts();
        totalAmount=cart.getBillSumpUp();
        return SUCCESS;
    }
    
}
