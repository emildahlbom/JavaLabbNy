package ui;

import java.sql.Timestamp;
import java.util.List;

public class OrderInfo {

    private List<ProductInfo> products;
    private String username;
    private Timestamp timestamp;

    public OrderInfo(List<ProductInfo> products, String username, Timestamp timestamp) {
        this.products = products;
        this.username = username;
        this.timestamp = timestamp;
    }

    public List<ProductInfo> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInfo> products) {
        this.products = products;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
