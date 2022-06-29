package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomersTest {
    Customers customer = new Customers("David", "Male");
    Products product  = new Products("Egg");

    @Test
    void buyGoods() {
        int count = customer.getProducts().size();
        customer.buyGoods(product);
        // Number of goods for a customer increases by one after buying
        assertEquals(count+1, customer.getProducts().size());

    }
}