package bo;

import db.UserDAO;

public class User {

    private String username;
    private String password;

    // TODO name, surname, address etc?

    static boolean validate(User user) {
        return UserDAO.getUser(user) != null;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
