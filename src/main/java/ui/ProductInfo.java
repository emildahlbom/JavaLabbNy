package ui;

// Bärare mellan UI lagret och verksamhetslagret.
public class ProductInfo {

    private String name;
    private int price;

    public ProductInfo(String name, int price) {
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
