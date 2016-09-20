package ca.six.demo.lib.mock.login;

/**
 * Created by songzhw on 2016-09-19.
 */
public class LoginPresenter {
    public UserManager userManager = new UserManager();

    public void login(String username, String password) {
        if (username == null || username.length() == 0) return;
        if (password == null || password.length() < 6) return;
        userManager.doLogin(username, password);
    }
}
