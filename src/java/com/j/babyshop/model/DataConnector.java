/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.babyshop.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author FIA
 */
public class DataConnector {

    private static final String uri = "jdbc:derby://localhost:1527/BabyShop";
    private static final String user = "root";
    private static final String pass = "0412";
    private static final String driver = "org.apache.derby.jdbc.ClientDriver";
    private static Connection connection;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection != null) {
            return connection;
        } else {
            Class.forName(driver);
            connection = DriverManager.getConnection(uri, user, pass);
            return connection;
        }
    }
}
