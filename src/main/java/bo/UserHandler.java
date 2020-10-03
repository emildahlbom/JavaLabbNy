package bo;

import ui.UserInfo;

// facade objekt för att man inte ska ha tillgång till det "riktiga" User objektet utanför verksamhetslagret.
public class UserHandler {

    public boolean validate(String username, String password) {
        return User.validate(username, password);
    }

    public boolean register(UserInfo userInfo) {
        return User.register(new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getName(), userInfo.getAddress()));
    }

    public UserInfo getUser(String username) {
        User user = User.getUser(username);
        // Omvandlar till UserInfo för att skydda datat.
        return new UserInfo(user.getUsername(), user.getPassword(), user.getName(), user.getAddress());
    }
}
