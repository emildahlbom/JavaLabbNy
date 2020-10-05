package bo;

import db.ProductDB;

import java.util.List;

public class Product {

    private String name;
    private int price;

    static public List<Product> getProducts() {
        return ProductDB.getProducts();
    }

    // Protected eftersom det inte är tänkt att skapas utanför verksamhetslagret.
    protected Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
