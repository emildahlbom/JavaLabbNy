package db;

import bo.User;

import java.sql.*;

public class UserDB extends bo.User{

    // Subklass till User för att kunna göra konstruktorn privat och User till protected
    private UserDB(String username, String password, String name, String address) {
        super(username, password, name, address);
    }

    public static User getUser(String username) {
        try {
            Connection connection = DBManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ? ");
            preparedStatement.setString(1, username);

            ResultSet resultset = preparedStatement.executeQuery();

            if (resultset.next()) {
                return new UserDB(resultset.getString("username"), resultset.getString("password"), resultset.getString("name"), resultset.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void register(User user) {
        try {
            Connection connection = DBManager.getConnection();

            String sql = "insert into users values(?, ?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getAddress());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
