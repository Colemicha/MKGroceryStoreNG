package model;

import java.util.ArrayList;

public class Customers implements BuyProducts{
    private String customerName;
    private String gender;
    private ArrayList<Products> products;

    public Customers (String customerName, String gender) {
        this.customerName = customerName;
        this.gender = gender;
        this.products = new ArrayList<>();
    }
    public void buyGoods(Products product) {
        products.add(product);
        System.out.println("Goods bought");

    }
    public ArrayList<Products> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getGender() {
        return gender;
    }
    public void setName(String customerName) {
        this.customerName = customerName;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String toBuy(Customers customers) {
        return this.getCustomerName() + "buy products.";
    }
}
