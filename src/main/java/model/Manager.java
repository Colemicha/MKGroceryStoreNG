package model;


import interfaces.ManagerRole;

import java.util.ArrayList;

public class Manager extends Staff implements ManagerRole{


    public Manager(String name) {
        super(name);
    }


    public String toHire(Cashier addCashier, int requiredMark) {
        if(requiredMark > 75) {
            return "Cashier "+addCashier.getName()+" you are hired";
        }
        else {
            return addCashier.getName()+ "you are not fit for the job";
        }
    }
}
