package bo;

import ui.UserInfo;

public class UserHandler {

    public boolean validate(UserInfo userInfo) {
        return User.validate(new User(userInfo.getUsername(), userInfo.getPassword()));
    }

    // public void createUser()

    // public UserInfo getUser()
}
