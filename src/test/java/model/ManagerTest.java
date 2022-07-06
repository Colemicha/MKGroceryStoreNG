package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManagerTest {
    Manager manager = new Manager("Godwin");
    Customers customer = new Customers("David", "Male");
    Cashier cashier = new Cashier("Michelle", customer);

    @Test
    void toHireTest() {
        String actual = manager.toHire(cashier);
        String expected = "Congrats "+cashier.getName()+"!!! you are hired";
        assertEquals(expected, actual);

        String actual2 = manager.toHire(cashier);
        String expected2 = "Cashier "+cashier.getName()+" already hired";

        assertEquals(expected2, actual2);


    }
}