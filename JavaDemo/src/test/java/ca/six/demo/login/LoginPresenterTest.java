package ca.six.demo.login;

import ca.six.demo.lib.mock.login.LoginPresenter;
import ca.six.demo.lib.mock.login.UserManager;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by songzhw on 2016-09-19.
 *
 * : 验证这个对象的某些方法的调用情况，调用了多少次，参数是什么等等
 */
public class LoginPresenterTest {
    @Test
    public void testLogin() {
        LoginPresenter presenter = new LoginPresenter();
        UserManager userManager = mock(UserManager.class);
        presenter.userManager = userManager;

        presenter.login("szw","my_pwd");
        verify(userManager).doLogin(anyString(),anyString());
    }
}
