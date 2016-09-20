package ca.six.demo.lib.mock.login2;

/**
 * Created by songzhw on 2016-09-19.
 *
 */
public class LoginPresenter2 {
    public UserManager2 userManager = new UserManager2();
    public PasswordValidate2 validator = new PasswordValidate2();

    public void login(String username, String password) {
        if (username == null || username.length() == 0) return;
        if (password == null || password.length() == 0) return;

        System.out.println("szw : validate = "+validator.validate(password));
        if(!validator.validate(password)) return;

        userManager.doLogin(username, password);
    }
}
