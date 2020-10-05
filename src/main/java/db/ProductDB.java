package db;

import bo.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Subklass till User för att kunna göra konstruktorn privat och User till protected
public class ProductDB extends bo.Product{

    private ProductDB(String name, int price) {
        super(name, price);
    }

    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        try {
            Connection connection = DBManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("select * from products");

            while (resultset.next()) {
                String name = resultset.getString("name");
                int price = resultset.getInt("price");
                products.add(new ProductDB(name, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
