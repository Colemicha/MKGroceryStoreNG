package model;

import Enums.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Products {
    private String productName;
    private long quantity;
    private double unitPrice;
    private String category;
    private Status status;


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double price) {
        this.unitPrice = price;
    }


    public Products(String category, String product,long quantity, double price){//for store
        this.productName = product;
        this.quantity = quantity;
        this.unitPrice = price;
        this.category = category;
    }


    public Products(String customerProducts, long quantity) {
        this.productName = customerProducts;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-16s %-10d %-10.2f", category, productName, quantity, unitPrice) ;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static List<Products> categorize(String category) {
        List<Products>categoryList = new ArrayList<>();
        for(Products product: categoryList) {
            if(product.getCategory().equalsIgnoreCase(category)) {
                if(product.getStatus()==Status.IN_STOCK){
                    categoryList.add(product);
                }
            }
        }
        return categoryList;
    }
}
