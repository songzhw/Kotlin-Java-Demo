package ca.six.demo.login;

import ca.six.demo.lib.mock.login2.LoginPresenter2;
import ca.six.demo.lib.mock.login2.PasswordValidate2;
import ca.six.demo.lib.mock.login2.UserManager2;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by songzhw on 2016-09-19.
 *
 * : 指定mock对象的某些方法的行为
 */
public class LoginPresenterTest2 {

    @Test
    public void testLogin2(){
        LoginPresenter2 presenter = new LoginPresenter2();
        UserManager2 userManager = mock(UserManager2.class);
        presenter.userManager = userManager;

        PasswordValidate2 validator = mock(PasswordValidate2.class);
        when(validator.validate("111")).thenReturn(true);
        when(validator.validate("222")).thenReturn(false);
//        when(validator.validate(anyString())).thenReturn(true);
        presenter.validator = validator;


        presenter.login("szw","111");
        verify(userManager).doLogin(anyString(),anyString());
    }
}
