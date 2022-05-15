package com.example.thunder_mediapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionToDB {

    static Connection con ;

    public static Connection createCon () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver") ;

            String name = "root" ;
            String pass = "" ;
            String url = "jdbc:mysql://localhost:3306/user_admin_info" ;
            con = DriverManager.getConnection(url, name, pass) ;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con ;
    }

    public static Connection createContoMedicine () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver") ;

            String name = "root" ;
            String pass = "" ;
            String url = "jdbc:mysql://localhost:3306/medicine" ;

            con = DriverManager.getConnection(url, name, pass) ;
        }catch (Exception e) {
            e.printStackTrace();
        }

        return con ;
    }

    public static Connection createConToOrders() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver") ;

            String name = "root" ;
            String pass = "" ;
            String url  = "jdbc:mysql://localhost:3306/user_orders" ;

            con = DriverManager.getConnection(url, name, pass) ;
        }catch (Exception e) {}

        return con ;
    }

    public static Connection createAdminConToOrders() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver") ;

            String name = "root" ;
            String pass = "" ;
            String url  = "jdbc:mysql://localhost:3306/admin_orders" ;

            con = DriverManager.getConnection(url, name, pass) ;
        }catch (Exception e) {}

        return con ;
    }
}
