package ca.six.demo.lib.mock.login3;

import ca.six.demo.lib.mock.login2.PasswordValidate2;
import ca.six.demo.lib.mock.login2.UserManager2;

/**
 * Created by songzhw on 2016-09-19.
 *
 */
public class LoginPresenter3 {
    public UserManager3 userManager = new UserManager3();
    public PasswordValidate2 validator = new PasswordValidate2();

    public void login(String username, String password) {
        if (username == null || username.length() == 0) return;
        if (password == null || password.length() == 0) return;

        System.out.println("szw validate = "+validator.validate(password));
        if(!validator.validate(password)) return;

        userManager.doLogin(username, password, new ILoginCallback() {
            @Override
            public void onSucc(String resp) {
                // view.onSuccLogin();
            }

            @Override
            public void onFail(Throwable throwable) {
                // view.onError();
            }
        });
    }
}
