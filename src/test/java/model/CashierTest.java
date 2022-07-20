package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {

    Customers customer;
    Cashier cashier;

    ArrayList<Products>products;
    Products product;
   @BeforeEach
 void setup(){
       customer = new Customers("Janet","Female",4000);
       cashier = new Cashier("Queen");

   }

   @Test
    void sellToCustomer() {
//       boolean actual = cashier.sellToCustomer(customer);
//       boolean expected = true;
//       assertEquals(actual, expected);

    }
}