package model;

public class Products {
    private String productName;



    public Products(String productName){
        this.productName = productName;
    }


    @Override
    public String toString() {
        return  productName ;
    }
}
