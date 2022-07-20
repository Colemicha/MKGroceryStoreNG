package model;

public class Staff {
    private int staffId;
    private String name;
    int count = 1;

    public Staff(String name) {
        this.name = name;
        this.staffId=count;
        count++;
    }

}
