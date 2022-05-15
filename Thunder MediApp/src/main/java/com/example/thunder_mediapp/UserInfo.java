package com.example.thunder_mediapp;

public class UserInfo {
    private String fName, lName, password, address, username, user_area ;


    public UserInfo(String fName, String lName, String password, String address, String username, String user_area) {
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.address = address;
        this.username = username ;
        this.user_area = user_area ;
    }

    public UserInfo(String fName, String lName, String password, String address, String username) {
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.address = address;
        this.username = username ;
    }

    public UserInfo() {}



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

    public String getUser_area() {
        return user_area;
    }

    public void setUser_area(String user_area) {
        this.user_area = user_area;
    }
}
