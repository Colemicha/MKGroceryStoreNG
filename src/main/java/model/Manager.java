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

    public ArrayList<Cashier> getCashier() {
        return cashier;
    }

    public void setCashier(ArrayList<Cashier> cashier) {
        this.cashier = cashier;
    }

    public String  toHire(Cashier addCashier) {

        if(cashier.contains(addCashier)){
            return "Cashier "+addCashier.getName()+" already hired";
        }
        else {
            cashier.add(addCashier);
            return "Congrats "+addCashier.getName()+"!!! you are hired";
        }
    }
}
