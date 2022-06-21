package model;


import interfaces.ManagerRole;

import java.util.ArrayList;

public class Manager extends Staff implements ManagerRole{
    private String name;
    private ArrayList<Cashier> cashier;

    public Manager(int staffId, String name) {
        super(staffId);
        this.name = name;
        this.cashier = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Void toHire(Cashier addCashier) {
        cashier.add(addCashier);
        System.out.println("Cashier added");

        return null;
    }
}
