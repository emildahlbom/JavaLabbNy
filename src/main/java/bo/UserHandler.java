package bo;

import ui.UserInfo;

public class UserHandler {

    public boolean validate(String username, String password) {
        return User.validate(username, password);
    }

    public boolean register(UserInfo userInfo) {
        return User.register(new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getName(), userInfo.getAddress()));
    }
}
