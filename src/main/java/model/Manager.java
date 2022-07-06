package model;


import interfaces.ManagerRole;

import java.util.ArrayList;

public class Manager extends Staff implements ManagerRole{

    private ArrayList<Cashier> cashiers;

    public Manager( String name) {
        super(name);
        this.cashiers = new ArrayList<>();
    }

    public ArrayList<Cashier> getCashiers() {
        return cashiers;
    }

    public void setCashiers(ArrayList<Cashier> cashiers) {
        this.cashiers = cashiers;
    }

    public String  toHire(Cashier addCashier) {

        if(cashiers.contains(addCashier)){
            return "Cashier "+addCashier.getName()+" already hired";
        }
        else {
            cashiers.add(addCashier);
            return "Congrats "+addCashier.getName()+"!!! you are hired";
        }
    }
}
