package model;

import java.util.ArrayList;
import java.util.List;

public class Cashier extends Staff implements cashierDuty{
    private String name;
    private Customers customers;
    private ArrayList<Products> products;

    public Cashier(int staffId, String name, Customers customers) {
        super(staffId);
        this.name = name;
        this.customers = customers;
        this.products = new ArrayList<>();
    }


    public void sellGoods(Products product){
        products.add(product);
        System.out.println("Goods sold");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;


    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }

    @Override
    public String issueReceipt() {
        return "Hello " + getCustomers().getCustomerName() +  " You Bought The following Products" + getProducts();
    }
}
