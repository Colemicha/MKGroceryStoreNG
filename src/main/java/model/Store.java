package model;

import Enums.Status;
import model.Cashier;
import model.Customers;
import model.Manager;
import model.Products;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;
import static model.Products.categorize;

public class Store {
    private ArrayList<Products> products=new ArrayList<>();
    private final HashMap<String, Products> inventory = new HashMap<>();
    private final HashMap<String, ArrayList<String>> category=new HashMap<>();


    private ArrayList<Cashier> cashiers;

    public Store(ArrayList<Products> products, ArrayList<Cashier> cashiers) {
        this.products = products;
        this.cashiers = cashiers;
    }

    public Store() {
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }

    public ArrayList<Cashier> getCashiers() {
        return cashiers;
    }

    public void setCashiers(ArrayList<Cashier> cashiers) {
        this.cashiers = cashiers;
    }


    public void readFile(){
        String file = "./src/main/resources/Products.csv";
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {
                String [] row = line.split(",");
                Products prod = new Products(row[0], row[1],parseLong(row[2]),parseDouble(row[3]));
                if(prod.getQuantity() > 0)  {
                    prod.setStatus(Status.IN_STOCK);
                }
                else{
                    prod.setStatus(Status.OUT_OF_STOCK);
                }
                if (inventory.containsKey(prod.getProductName())){
                    Products prodNew = inventory.get(prod.getProductName());
                    prodNew.setQuantity(prod.getQuantity() + prodNew.getQuantity());
                }
                else{
                    inventory.put(prod.getProductName(), prod);
                }
            }
            for(Products products1:inventory.values()){
                String name= products1.getProductName();
                String cat= products1.getCategory();
                if(category.containsKey(cat)){
                    if(!category.get(cat).contains(name)){
                        category.get(cat).add(name);
                    }
                }
                else {
                    ArrayList<String> add=new ArrayList<>();
                    add.add(name);
                    category.put(cat, add);
                }
            }
            for (Map.Entry<String, ArrayList<String>> entry: category.entrySet()){
                System.out.println(entry.getKey()+": ");
                for (String str: entry.getValue()){
                    System.out.print(str+", ");
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
       finally {
          try {
               reader.close();
          } catch (IOException e) {
                throw new RuntimeException(e);
           }
       }
        System.out.printf("%-10s %-16s %-10s %-10s","Category","Product","Quantity",
                "UnitPrice\n................................................\n");
        for(Map.Entry<String, Products> n : inventory.entrySet()) {
            System.out.println(String.format("%-10s %-16s %-10d %-10.2f", n.getValue().getCategory(), n.getValue().getProductName(), n.getValue().getQuantity(),
                    n.getValue().getUnitPrice()));
        }

    }

    public HashMap<String, Products> getInventory() {
        for(Products prod: inventory.values()){
            System.out.println(prod);
        }
        return inventory;
    }

    public boolean addToCustomerCart(Customers customer, String nameOfProduct, Long qty){
        if (this.inventory.containsKey(nameOfProduct)){
            Products productInStore = inventory.get(nameOfProduct);
            if(productInStore.getStatus()==Status.IN_STOCK){
                Products prod = new Products(productInStore.getProductName(),qty);
                productInStore.setQuantity(productInStore.getQuantity() - qty);
                customer.getCustomerCart().put(prod.getProductName(),prod);
                return true;
            }
            else{
                System.out.println("Not in stock");
                return false;
            }
        }
        else{
            System.out.println("Product Unavailable");
            return false;
        }
    }


}