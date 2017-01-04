package ca.six.demo.login;

import ca.six.demo.lib.mock.login2.PasswordValidate2;
import ca.six.demo.lib.mock.login3.ILoginCallback;
import ca.six.demo.lib.mock.login3.LoginPresenter3;
import ca.six.demo.lib.mock.login3.UserManager3;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by songzhw on 2016-09-19.
 *
 * : 指定mock对象的某些方法的行为
 */
@Ignore
public class LoginPresenterTest3 {
    @Captor
    private ArgumentCaptor<ILoginCallback> captor;

    @Test
    public void testLogin3(){
        LoginPresenter3 presenter = new LoginPresenter3();
        UserManager3 userManager = mock(UserManager3.class);
        presenter.userManager = userManager;

        PasswordValidate2 validator = mock(PasswordValidate2.class);
        when(validator.validate("111")).thenReturn(true);
        presenter.validator = validator;


        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] arguments = invocation.getArguments(); //login("","", callback)共3个参数
                ILoginCallback callback = (ILoginCallback) arguments[2]; // callback是第3个， 所以是[2]
                callback.onSucc("mock success!");
                return null;
            }
        })
        .when(userManager)
        .doLogin("szw","111", any(ILoginCallback.class));

        presenter.login("szw","111");
        assertEquals("mock success!", presenter.code);
    }
}
