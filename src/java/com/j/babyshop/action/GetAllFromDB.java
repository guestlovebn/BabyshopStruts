/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.babyshop.action;

import com.j.babyshop.entity.Product;
import com.j.babyshop.model.DataAccess;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author FIA
 */
public class GetAllFromDB extends ActionSupport {

    public String keyword;
    private ArrayList<Product> products;

    public String getKeyword() {
        return keyword;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String execute() throws Exception {
        return searchByName(); //To change body of generated methods, choose Tools | Templates.
    }

    private String searchByName() throws ClassNotFoundException, SQLException {
        String trimmedKeyword = keyword.trim().toLowerCase();
        products = DataAccess.searchByName(trimmedKeyword);
        if (products.size() != 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
}
