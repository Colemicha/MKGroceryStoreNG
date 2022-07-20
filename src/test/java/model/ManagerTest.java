package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManagerTest {
    Manager manager = new Manager("Godwin");
    Cashier cashier = new Cashier("Michelle");

    @Test
    void toHireTest() {
        cashier.setName("Mike");
        String actual = manager.toHire(cashier, 90);
        String expected = "Cashier "+cashier.getName()+" you are hired";
        assertEquals(expected, actual);
    }
}