package db;

import bo.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        try {
            Connection connection = DBManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("select * from products");

            while (resultset.next()) {
                String name = resultset.getString("name");
                int price = resultset.getInt("price");
                products.add(new Product(name, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
