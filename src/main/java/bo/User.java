package bo;

import db.UserDAO;

public class User {

    private String username;
    private String password;
    private String address;
    private String name;

    static boolean validate(String username, String password) {
        User user = UserDAO.getUser(username);
        return user != null && user.getUsername().equals(username) && user.getPassword().equals(password);
    }

    static boolean register(User user) {
        boolean isUsernameInUse = UserDAO.getUser(user.getUsername()) != null;
        if (isUsernameInUse) {
            return false;
        }
        UserDAO.register(user);
        return true;
    }

    public User(String username, String password, String name, String address) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
