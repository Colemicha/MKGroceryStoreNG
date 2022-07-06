package model;

import java.util.ArrayList;

public class Cashier extends Staff implements cashierDuty{
    private String name;
    private Customers customers;
    private ArrayList<Products> products;

    public Cashier(String name, Customers customers) {
        super(name);
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

    public void customerBuy(Customers customer){
        customer = this.customers;
        int total=0;
        String receipt="";
        for(Products customerList : customer.getProducts()){

            for(Products productsInStock: Products.Stock){
                if(productsInStock.getProduct().equals(customerList.getProduct())){
                    //this is where you check their quantities i.e customerList<=productInStock
                    if(customerList.getQuantity()<=productsInStock.getQuantity()) {
                        //the amount customerList and multiply by the price in productsInStock
                        double use= customerList.getQuantity()*productsInStock.getUnitPrice();
                        //add to total
                        total+=use;
                        System.out.println(productsInStock.getQuantity());
                        //remove qty in customerList from productsInStock
                        long minus=productsInStock.getQuantity()- customerList.getQuantity();
                        productsInStock.setQuantity(minus);
                        System.out.println(productsInStock.getQuantity());
                        // qty in customerList + name of customerList+ (qty in customerList*price in productsInStock)+\n
                        receipt+= customerList.getQuantity()+"\t"+ customerList.getProduct()+"\t \t"+use+"\n";
                    }
                }
            }
        }
        receipt+="\n"+total;
        if(customer.getWallet() >= total) {
            System.out.println(issueReceipt(receipt));
        }
        else {
            System.out.println("No sale");
        }

    }

    @Override
    public String issueReceipt(String s) {
        return "Hello " + getCustomers().getCustomerName() +  " You Bought The following Products" + getProducts()
                +"\n"+s;
    }
}
