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
   }

   @Test
    void customerBuy() {
       cashier.customerBuy();
    }
}