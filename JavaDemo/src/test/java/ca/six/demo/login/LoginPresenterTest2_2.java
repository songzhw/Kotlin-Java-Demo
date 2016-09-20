package ca.six.demo.login;

import ca.six.demo.lib.mock.login2.LoginPresenter2;
import ca.six.demo.lib.mock.login2.PasswordValidate2;
import ca.six.demo.lib.mock.login2.UserManager2;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by songzhw on 2016-09-19.
 *
 * : 指定mock对象的某些方法的行为
 */
public class LoginPresenterTest2_2 {

    @Test
    public void testLogin2_2(){
        LoginPresenter2 presenter = new LoginPresenter2();
        UserManager2 userManager = mock(UserManager2.class);
        presenter.userManager = userManager;

        PasswordValidate2 validator = spy(PasswordValidate2.class);
//        when(validator.validate(anyString())).thenReturn(true);
        presenter.validator = validator;


        presenter.login("szw","12");
        verify(userManager).doLogin(anyString(),anyString());
    }
}
