package ca.six.demo.login;

import ca.six.demo.lib.mock.login2.PasswordValidate2;
import ca.six.demo.lib.mock.login3.ILoginCallback;
import ca.six.demo.lib.mock.login3.LoginPresenter3;
import ca.six.demo.lib.mock.login3.UserManager3;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by songzhw on 2016-09-19.
 *
 * : 指定mock对象的某些方法的行为
 */
public class LoginPresenterTest3 {

    @Test
    public void testLogin3(){
        LoginPresenter3 presenter = new LoginPresenter3();
        UserManager3 userManager = mock(UserManager3.class);
        presenter.userManager = userManager;

        PasswordValidate2 validator = mock(PasswordValidate2.class);
        when(validator.validate("111")).thenReturn(true);
        when(validator.validate("222")).thenReturn(false);
        presenter.validator = validator;

        presenter.login("szw","33");
//        verify(userManager).doLogin(anyString(),anyString(), any(ILoginCallback.class));

        // TODO? 这里不管什么密码，都能测试通过！ 奇怪了！！！
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] arguments = invocation.getArguments();
                ILoginCallback callback = (ILoginCallback) arguments[2];
                callback.onSucc("mock success!");
                return 0;
            }
        })
        .when(userManager)
        .doLogin(anyString(), anyString(), any(ILoginCallback.class));
    }
}
