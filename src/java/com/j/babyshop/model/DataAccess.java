/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.babyshop.model;

import com.j.babyshop.entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author FIA
 */
public class DataAccess {

    public static ArrayList<Product> collectData() throws ClassNotFoundException, SQLException {
        ArrayList<Product> list = new ArrayList<>();
        Connection connection = com.j.babyshop.model.DataConnector.getConnection();
        String query = "SELECT * FROM Product";
        PreparedStatement stm = connection.prepareCall(query);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Product product = new Product(rs.getInt("id"), rs.getString("name"), rs.getFloat("price"));
            list.add(product);
        }
        return list;
    }

    public static ArrayList<Product> searchById(int id) throws ClassNotFoundException, SQLException {
        ArrayList<Product> list = new ArrayList<>();
        Connection connection = com.j.babyshop.model.DataConnector.getConnection();
        String query = "SELECT * FROM Product WHERE id=?";
        PreparedStatement stm = connection.prepareCall(query);
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Product product = new Product(rs.getInt("id"), rs.getString("name"), rs.getFloat("price"));
            list.add(product);
        }
        return list;
    }

    public static ArrayList<Product> searchByName(String trimmedName) throws ClassNotFoundException, SQLException {
        ArrayList<Product> list = new ArrayList<>();
        ArrayList<Product> input = collectData();
        for (Product p : input) {
            if (p.getName().trim().toLowerCase().contains(trimmedName)) {
                list.add(p);
            }
        }
        return list;
    }
}
