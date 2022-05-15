package com.example.thunder_mediapp;

public class AdminInfo {
    private String fName, lName, password, address, username, shop_area, shop_name, nid_number, license, email ;

    public AdminInfo(String fName, String lName, String password, String address, String username, String shop_area, String shop_name, String nid_number, String license, String email) {
        this.shop_name = shop_name ;
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.address = address;
        this.username = username;
        this.shop_area = shop_area;
        this.nid_number = nid_number ;
        this.license = license ;
        this.email =email ;
    }

    public AdminInfo(String fName, String lName, String password, String address, String username, String shop_name) {
        this.shop_name = shop_name ;
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.address = address;
        this.username = username;
    }

    public AdminInfo () {}

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getShop_area() {
        return shop_area;
    }

    public void setShop_area(String shop_area) {
        this.shop_area = shop_area;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getNid_number() {
        return nid_number;
    }

    public void setNid_number(String nid_number) {
        this.nid_number = nid_number;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
