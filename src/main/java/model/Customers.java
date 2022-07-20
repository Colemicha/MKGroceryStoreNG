package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Customers implements Comparable <Customers>{
    private String customerName;
    private String gender;
    private double wallet;
    private int itemsInCustomerCart;
    private Map<String, Products> customerCart;



    public Customers (String customerName, String gender, double wallet) {
        this.customerName = customerName;
        this.gender = gender;
        this.wallet = wallet;
        this.customerCart = new LinkedHashMap<>();
    }

    public int getItemsInCustomerCart() {
        return itemsInCustomerCart;
    }

    public void setItemsInCustomerCart(int itemsInCustomerCart) {
        this.itemsInCustomerCart = itemsInCustomerCart;
    }

    public Map<String, Products> getCustomerCart() {
        return customerCart;
    }

    public void setCustomerCart(Map<String, Products> customerCart) {
        this.customerCart = customerCart;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
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
    public int compareTo(Customers o) {
        int thisTotal = 0;
        for(Products products: this.customerCart.values()) {
            thisTotal += products.getQuantity();
        }
        int oTotal = 0;
        for(Products products : o.customerCart.values()) {
            oTotal += products.getQuantity();
        }
        if(thisTotal == oTotal) {
            return 0;
        }
        if(thisTotal > oTotal) {
            return 1;
        }
        else {
            return -1;
        }
    }
    public boolean addToMyCustomerCart(Products products) {
        if(this.customerCart.containsKey(products.getProductName())) {
            Products productsStock = this.customerCart.get(products.getProductName());
            productsStock.setQuantity(productsStock.getQuantity() + products.getQuantity());
            return true;
        }
        else {
            this.customerCart.put(products.getProductName(), products);
        }
        this.itemsInCustomerCart += products.getQuantity();
        return false;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customerName = " + customerName + '\'' +
                ", gender = " + gender + '\'' +
                ", wallet = " + wallet +
                ", customerCart = " + customerCart +
                '}';
    }
}
