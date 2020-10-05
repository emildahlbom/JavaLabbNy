package db;

import bo.Order;
import com.google.gson.Gson;
import java.sql.*;

public class OrderDB {

    public static long placeOrder(Order order) {
        try {
            Connection connection = DBManager.getConnection();

            // parametern "default" är AUTO INCREMENT fältet.
            String sql = "insert into orders values(default, ?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, order.getUsername());
            statement.setTimestamp(2, order.getTimestamp());
            statement.setString(3, new Gson().toJson(order.getProducts()));

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();
            long orderId = generatedKeys.getLong(1);
            return orderId;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
