package com.example.thunder_mediapp;

public class Medicine {
    private String name, strength, indegrants, com_name ;
    private int price ;

    public Medicine(String name, String strength, String indegrants, String com_name, int price) {
        this.name = name;
        this.strength = strength;
        this.indegrants = indegrants;
        this.com_name = com_name;
        this.price = price ;
    }

    public Medicine () {}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getIndegrants() {
        return indegrants;
    }

    public void setIndegrants(String indegrants) {
        this.indegrants = indegrants;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
