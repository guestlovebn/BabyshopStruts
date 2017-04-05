/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.babyshop.action;

import com.j.babyshop.entity.Product;
import com.j.babyshop.model.Cart;
import com.j.babyshop.model.DataAccess;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;

/**
 *
 * @author FIA
 */
public class AddToCart extends ActionSupport {

    private int productId;

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String execute() throws Exception {
        return addToCart(); //To change body of generated methods, choose Tools | Templates.
    }

    private String addToCart() throws ClassNotFoundException, SQLException {
        Cart cart = (Cart) ActionContext.getContext().getSession().get("cart");
        if (cart == null) {
            cart = new Cart();
        }
        Product p = DataAccess.searchById(productId).get(0);
        if (p.getId() == 0) {
            return ERROR;
        }
        cart.putInto(p);
        ActionContext.getContext().getSession().put("cart", cart);
        return SUCCESS;
    }
}
