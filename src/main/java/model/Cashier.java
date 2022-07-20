package model;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Cashier extends Staff {
    private String name;

    public Cashier(String name) {

        super(name);
    }


    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private boolean printReceipt(Customers customer) {
        System.out.println("ProductName   Qty   Amount");
        for (Products product : customer.getCustomerCart().values()) {
            System.out.println(product.getProductName() + "    " + product.getQuantity() + "  " + (product.getUnitPrice() * product.getQuantity()));
        }
        return true;
    }

    /*
   get the total amount of goods the customer is buying.
   check if the wallet balance is greater than total amount
   if yes sell and issue receipt reduce the wallet balance, if no, print insufficient funds.
    */
    public boolean sellToCustomer(Customers customer, HashMap<String, Products> inventory) {
        double totalAmount = 0;
        for (Products product : customer.getCustomerCart().values()) {
            String key = product.getProductName();
            product.setUnitPrice(inventory.get(key).getUnitPrice());
            totalAmount += inventory.get(key).getUnitPrice() * product.getQuantity();
        }
        if (customer.getWallet() > totalAmount) {
            customer.setWallet(customer.getWallet() - totalAmount);
            printReceipt(customer);
            return true;
        } else {
            System.out.println("Insufficient Funds to carry out this transaction");
            return false;
        }
    }
    public int CustomerProductIndex(Customers customers, String customerProducts) {
        int position = -1;
        for(Products products : customers.getCustomerCart().values()) {
            if(Objects.equals(products.getProductName(), customerProducts)) {

            }

        }

    }

    public String sortCustomersByQueue() {
        Store store = new Store();
        store.getProducts().forEach(products -> {
            Comparable<Customers> customersComparable = new Comparable<Customers>() {
                @Override
                public int compareTo(Customers o) {

                    return 0;
                }
            }
        });

    }


}