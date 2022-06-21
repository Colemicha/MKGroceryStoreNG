import model.Cashier;
import model.Customers;
import model.Manager;
import model.Products;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Customers customer = new Customers("David", "Male");
        customer.buyGoods(new Products("Egg"));
        customer.buyGoods(new Products("Bread"));
        Products product1 = new Products("Egg");
        Products product2 = new Products("Bread");
        Cashier cashier = new Cashier(1234, "Michelle",customer) ;
        cashier.sellGoods(product1);
        cashier.sellGoods(product2);

        System.out.println(cashier.issueReceipt());

        Manager manager = new Manager(1234, "Godwin");
        manager.toHire(cashier);
    }
}