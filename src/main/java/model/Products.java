package model;

import Enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private String Product;
    private long Quantity;
    private double UnitPrice;
    private String Category;
    private Status status;

public static ArrayList<Products> Stock=new ArrayList<>();

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String productName) {
        this.Product = productName;
    }

    public long getQuantity() {
        return Quantity;
    }

    public void setQuantity(long quantity) {
        this.Quantity = quantity;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double price) {
        this.UnitPrice = price;
    }

    public Products(String category, String product,long quantity, double price){//for store
        this.Product = product;
        this.Quantity = quantity;
        this.UnitPrice = price;
        this.Category = category;
    }



    public Products(String product, long quantity){//customer
        this.Product = product;
        this.Quantity = quantity;
    }

    @Override
    public String toString() {
        return  Product ;
    }

    public static List<Products> categorize(String category) {
        List<Products>categoryList = new ArrayList<>();
        for(Products product: Stock) {
            if(product.getCategory().equalsIgnoreCase(category)) {
                categoryList.add(product);
            }
        }
        return categoryList;
    }
}
