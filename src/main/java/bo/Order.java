package bo;

import db.OrderDAO;

import java.sql.Timestamp;
import java.util.List;

public class Order {

    private List<Product> products;
    private String username;
    private Timestamp timestamp;

    public static long PlaceOrder(Order order) {
        return OrderDAO.placeOrder(order);
    }

    public Order(List<Product> products, String username, Timestamp timestamp) {
        this.products = products;
        this.username = username;
        this.timestamp = timestamp;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
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
