package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {

    Cashier cashier;
    Customers customers;
    Products products;

    @BeforeEach
    void setUp() {
        products = new Products("Egg");
        customers = new Customers("David","Male");
        cashier = new Cashier(1234,"Michelle",customers);
    }

    @Test
    void sellGoods() {
        cashier.sellGoods(products);
        int count = cashier.getProducts().size();
        cashier.sellGoods(products);
        // Number of goods for a cashier increases by one after buying
        assertEquals(count+1, cashier.getProducts().size());
    }
}