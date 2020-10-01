package db;

import bo.User;

import java.sql.*;

public class UserDAO {

    public static User getUser(User user) {
        try {
            Connection connection = DBManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from login where username = ? and password = ? ");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            ResultSet resultset = preparedStatement.executeQuery();

            if (resultset.next()) {
                return new User(resultset.getString("username"), resultset.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
