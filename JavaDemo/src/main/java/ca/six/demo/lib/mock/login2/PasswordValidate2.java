package ca.six.demo.lib.mock.login2;

/**
 * Created by songzhw on 2016-09-19.
 */
public class PasswordValidate2 {
    public boolean validate(String pwd){
        return pwd.length() >= 3;
    }
}
