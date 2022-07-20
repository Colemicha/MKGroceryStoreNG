import model.Cashier;
import model.Customers;
import model.Products;
import model.Store;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Customers customer = new Customers("David", "Male", 2500);
        Cashier cashier = new Cashier("Uche");
        Store store = new Store();
        store.readFile();
        store.addToCustomerCart(customer, "Carrot", (long)40);

        System.out.println(customer.getCustomerCart().size());

        System.out.println("---------------------------------");
        cashier.sellToCustomer(customer, store.getInventory());
        store.getInventory();

        Customers Michael = new Customers("Michael","Male",14000);
        Customers Isaiah = new Customers("Isaiah", "Male",12000);
        Customers Michelle = new Customers("Michelle","Female",23000);
        Customers Maurice = new Customers("Maurice","Male",9500);



         Michael.addToMyCustomerCart(new Products("Carrot",14));
         Isaiah.addToMyCustomerCart(new Products("Carrot",150));
         Michelle.addToMyCustomerCart(new Products("Carrot",16));
         Maurice.addToMyCustomerCart(new Products("Carrot",19));

        List<Customers> customers = new ArrayList<>();

        customers.add(Michael);
        customers.add(Isaiah);


        customers.add(Michelle);
        customers.add(Maurice);

      Queue<Customers> queue = new PriorityQueue<>(Comparator.reverseOrder());
       while(customers.iterator().hasNext()) {
       queue.offer(customers.remove(0));
          for(Customers myCustomers : queue) {
             System.out.println(myCustomers.toString());
           }
           System.out.println("--------------------------------");
      }
      while(queue.iterator().hasNext()) {
           cashier.sellToCustomer(queue.poll(), store.getInventory());
          System.out.println();
          for(Customers myCustomers : queue) {
              System.out.println(myCustomers.toString());
          }
           System.out.println("--------------------------------");
       }

    }

}
