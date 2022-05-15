package com.example.thunder_mediapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class Database_Management {
    public static void insertIntoDB (UserInfo info) {
        Connection con = ConnectionToDB.createCon() ;

        try {
            PreparedStatement pst = con.prepareStatement("insert into userinfo (fName, lName, password, address, username, userarea) values (?, ?, ?, ?, ?,?)") ;
            pst.setString(1, info.getfName());
            pst.setString(2, info.getlName());
            pst.setString(3, info.getPassword());
            pst.setString(4, info.getAddress());
            pst.setString(5, info.getUsername());
            pst.setString(6, info.getUser_area());

            pst.executeUpdate() ;

        }catch (Exception e) {}
    }

    public static void deleteFromDB (int id) throws Exception {
        Connection con = ConnectionToDB.createCon() ;

        String q = "delete from userinfo where id=?" ;

        PreparedStatement pst = con.prepareStatement(q) ;

        pst.setInt(1, id);

        pst.executeUpdate() ;
    }

    public static void deleteOrdersFromDB (String name) {
        try {
            Connection con = ConnectionToDB.createConToOrders() ;
            String q = "delete from " + name ;

            PreparedStatement ps = con.prepareStatement(q) ;
            ps.executeUpdate() ;
        }catch (Exception e) {}

    }

    public static String[] fletchPassFromDB (String name) throws Exception {
        String search = "\"" + name + "\"" ;
        Connection con = ConnectionToDB.createCon() ;
        String[] st = new String[2] ;
        String q = "select password from userinfo where username=" + search  ;
        Statement sm = con.createStatement() ;
        ResultSet rs = sm.executeQuery(q) ;

        rs.next() ;
        st[0] = name;
        st[1] = rs.getString("password") ;

        return st ;
    }

    public static UserInfo fletchDataFromDB (String id)  {
        String search = "\"" + id + "\"" ;
        UserInfo info = new UserInfo() ;
        Connection con = ConnectionToDB.createCon() ;
        String q = "select * from userinfo where username=" + search;
        try {
            Statement sm = con.createStatement() ;
            ResultSet rs= sm.executeQuery(q) ;

            rs.next() ;
            info.setfName(rs.getString("fName") );
            info.setlName(rs.getString("lName") );
            info.setPassword(rs.getString("password") );
            info.setAddress(rs.getString("address")) ;
            info.setUsername(rs.getString("username")); ;
            info.setUser_area(rs.getString("userarea")); ;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return info ;
    }

    public static AdminInfo fletchAdminDataFromDB (String id)  {
        String search = "\"" + id + "\"" ;
        AdminInfo info = new AdminInfo() ;
        Connection con = ConnectionToDB.createCon() ;
        String q = "select * from admininfo where username=" + search;
        try {
            Statement sm = con.createStatement() ;
            ResultSet rs= sm.executeQuery(q) ;

            rs.next() ;
            info.setfName(rs.getString("fName") );
            info.setlName(rs.getString("lName") );
            info.setPassword(rs.getString("password") );
            info.setAddress(rs.getString("address")) ;
            info.setUsername(rs.getString("username")); ;
            info.setShop_area(rs.getString("shoparea"));
            info.setShop_name(rs.getString("shopname"));
            info.setEmail(rs.getString("email"));
            info.setLicense(rs.getString("license"));
            info.setNid_number(rs.getString("nid"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return info ;
    }

    public static void UpdateUserDB (String name, UserInfo info) throws Exception {
        Connection con = ConnectionToDB.createCon() ;
        String q = "update userinfo set fName=?, lName=?, password=?, address=?, username=? where username='" +name + "'"  ;

        PreparedStatement st = con.prepareStatement(q) ;
        st.setString(1, info.getfName());
        st.setString(2, info.getlName());
        st.setString(3, info.getPassword());
        st.setString(4, info.getAddress());
        st.setString(5, info.getUsername());

        st.executeUpdate() ;
    }

    public static void UpdateAdminDB (String name, AdminInfo info) throws Exception {
        Connection con = ConnectionToDB.createCon() ;
        String q = "update admininfo set fName=?, lName=?, password=?, address=?, username=?, shopname=? where username='" +name + "'"  ;

        PreparedStatement st = con.prepareStatement(q) ;
        st.setString(1, info.getfName());
        st.setString(2, info.getlName());
        st.setString(3, info.getPassword());
        st.setString(4, info.getAddress());
        st.setString(5, info.getUsername());
        st.setString(6, info.getShop_name());

        st.executeUpdate() ;
    }
    public static boolean checkOnServer (String uname) {
        String s = "\"" + uname + "\"" ;
        Connection con = ConnectionToDB.createCon() ;

        try {
            String q = "select username from userinfo where username=" + s ;
            Statement statement = con.createStatement() ;
            ResultSet set = statement.executeQuery(q) ;

            if (set.next()) return false ;

        }catch (Exception e) {}

        return true ;
    }

    public static boolean checkAdminOnServer (String uname) {
        String s = "\"" + uname + "\"" ;
        Connection con = ConnectionToDB.createCon() ;

        try {
            String q = "select username from admininfo where username=" + s ;
            Statement statement = con.createStatement() ;
            ResultSet set = statement.executeQuery(q) ;

            if (set.next()) return false ;

        }catch (Exception e) {}

        return true ;
    }


    public static ObservableList<Medicine> fletchDataFromMedicine (String name) throws Exception {
        int i=0 ;
        Connection con = ConnectionToDB.createContoMedicine() ;
        ObservableList<Medicine> list = FXCollections.observableArrayList() ;
        String q = "select * from "+ name  ;

        Statement st = con.createStatement() ;
        ResultSet set = st.executeQuery(q) ;

        while (set.next()) {
            String t_name = set.getString("name");
            String t_strength =  set.getString("strenght");
            String t_indegrants = set.getString("indegrants");
            String t_com =  set.getString("company_name");
            int t_price =set.getInt("price") ;
            list.add(new Medicine(t_name, t_strength, t_indegrants, t_com, t_price)) ;
        }

        return list ;
    }

    public static void insertMedicinetoDB(Medicine med, String name) throws Exception {
        Connection con = ConnectionToDB.createContoMedicine() ;

        String s_capsule = "insert into "+ name+ " (name, strenght, indegrants, company_name, price) values (?, ?, ?, ?, ?)" ;

        PreparedStatement ps = con.prepareStatement(s_capsule) ;
        ps.setString(1, med.getName());
        ps.setString(2, med.getStrength());
        ps.setString(3, med.getIndegrants());
        ps.setString(4, med.getCom_name());
        ps.setString(5, String.valueOf(med.getPrice()));
        ps.executeUpdate() ;
    }


    public static String[] fletchAdminPassFromDB (String name) throws Exception {
        String search = "\"" + name + "\"" ;
        Connection con = ConnectionToDB.createCon() ;
        String[] st = new String[2] ;
        String q = "select password from admininfo where username=" + search  ;
        Statement sm = con.createStatement() ;
        ResultSet rs = sm.executeQuery(q) ;

        rs.next() ;
        st[0] = name;
        st[1] = rs.getString("password") ;

        return st ;
    }

    public static void insertAdminIntoDB (AdminInfo info) throws SQLException {
        Connection con = ConnectionToDB.createCon() ;

        PreparedStatement pst = con.prepareStatement("insert into admininfo (fName, lName, password, address, username, shoparea, shopname, nid, license, email) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)") ;
        pst.setString(1, info.getfName());
        pst.setString(2, info.getlName());
        pst.setString(3, info.getPassword());
        pst.setString(4, info.getAddress());
        pst.setString(5, info.getUsername());
        pst.setString(6, info.getShop_area());
        pst.setString(7, info.getShop_name());
        pst.setString(8, info.getNid_number());
        pst.setString(9, info.getLicense());
        pst.setString(10,info.getEmail());

        pst.executeUpdate() ;
    }

    public static void insertIntoOrders (String uname, String name, int price) throws Exception {
        Connection con = ConnectionToDB.createConToOrders() ;

        String q = "insert into " + uname+ " (medname, price) values (?,?)" ;

        PreparedStatement ps = con.prepareStatement(q) ;

        ps.setString(1, name);
        ps.setInt(2, price);

        ps.executeUpdate();
    }

    public static ArrayList<UserOrder> fletchDataFromOrders (String name) throws Exception {

        ArrayList<UserOrder> list = new ArrayList<>() ;
        Connection co = ConnectionToDB.createConToOrders() ;

        String q = "select * from " + name  ;

        Statement st = co.createStatement() ;
        ResultSet resultSet = st.executeQuery(q) ;

        while (resultSet.next()) {
            list.add(new UserOrder(resultSet.getString("medname"), resultSet.getInt("price"))) ;
        }
        return list ;
    }

    public static void createTable (String uname) throws Exception {
        Connection con = ConnectionToDB.createConToOrders() ;
        String q = "create table " + uname + " (medname varchar(255), price int) ;" ;

        PreparedStatement st = con.prepareStatement(q) ;
        st.executeUpdate() ;
    }

    public static void createTablesOnAdmin (String name) throws Exception {
        Connection con = ConnectionToDB.createAdminConToOrders() ;
        String q = "create table " + name + " (medname varchar(255), strength varchar(255));" ;

        PreparedStatement s = con.prepareStatement(q) ;
        s.executeUpdate() ;
    }

    public static ArrayList<String> getTablesFromOrders () throws Exception {
        ArrayList<String> list = new ArrayList<>() ;
        Connection con = ConnectionToDB.createConToOrders() ;

        String q = "show tables from user_orders" ;

        Statement st = con.createStatement() ;
        ResultSet set = st.executeQuery(q) ;

        while (set.next()) {
            list.add(set.getString("Tables_in_user_orders")) ;
        }

        return list ;
    }

    public static int getTotalAmount (String name) throws Exception {
        Connection con = ConnectionToDB.createConToOrders() ;

        String q  = "select price from " + name ;

        Statement st = con.createStatement() ;
        ResultSet set = st.executeQuery(q) ;

        int sum = 0;

        while (set.next()) {
            sum += set.getInt("price") ;
        }

        return sum ;
    }

    public static ObservableList<String> getShopNearMe (String name) throws Exception {
        ObservableList<String> s = FXCollections.observableArrayList();
        Connection con = ConnectionToDB.createCon();

        String q = "select shopname from admininfo where shoparea = '" + name + "'" ;

        Statement st = con.createStatement() ;
        ResultSet rs = st.executeQuery(q) ;

        while (rs.next()) {
            s.add(rs.getString("shopname")) ;
        }

        return s ;
    }
}
