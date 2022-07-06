import Enums.Status;
import model.Cashier;
import model.Customers;
import model.Manager;
import model.Products;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static model.Products.Stock;
import static model.Products.categorize;

public class Store {

    public static void main(String[] args) {
        Customers customer = new Customers("David", "Male");
        readFile();


        Cashier cashier = new Cashier("Michelle",customer) ;
        cashier.customerBuy(customer);
        Manager manager = new Manager("Godwin");
        manager.toHire(cashier);

        customer.getProducts().add(new Products("Carrot", 10));
        cashier.customerBuy(customer);
        categorize("Bar");
    }

    public static void readFile(){
        ArrayList<Products>products = new ArrayList();
        String file = "/Users/mac/IdeaProjects/MKGroceryStore/products.csv";
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {
                String [] row = line.split(",");
                Products prod = new Products(row[0], row[1],Long.valueOf(row[2]),Double.valueOf(row[3]));
                boolean found=false;
                for(Products x: Stock) {
                    if(prod.getProduct().equals(x.getProduct())){
                        x.setQuantity(prod.getQuantity()+ x.getQuantity());
                        found=true;
                        break;
                    }
                }
                if(!found){
                 if(prod.getQuantity() > 0)   {
                     prod.setStatus(Status.IN_STOCK);
                 }
                 else{
                     prod.setStatus(Status.OUT_OF_STOCK);
                 }
                    Stock.add(prod);
                }



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
        for(Products n: Products.Stock) {
            System.out.println(n.getCategory() + " " + n.getProduct() + " " + n.getQuantity() + " " +n.getUnitPrice());
        }
    }


}