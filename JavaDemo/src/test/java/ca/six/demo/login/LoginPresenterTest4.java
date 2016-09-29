package ca.six.demo.login;

import ca.six.demo.lib.mock.login2.PasswordValidate2;
import ca.six.demo.lib.mock.login3.ILoginCallback;
import ca.six.demo.lib.mock.login3.LoginPresenter3;
import ca.six.demo.lib.mock.login3.UserManager3;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginPresenterTest4 {
    @Captor
    private ArgumentCaptor<ILoginCallback> captor;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLogin4() {
        LoginPresenter3 presenter = new LoginPresenter3();
        UserManager3 userManager = mock(UserManager3.class);
        presenter.userManager = userManager;

        PasswordValidate2 validator = mock(PasswordValidate2.class);
        when(validator.validate("111" )).thenReturn(true);
        presenter.validator = validator;

        presenter.login("szw", "111");
        verify(userManager).doLogin(anyString(), anyString(), captor.capture());
        captor.getValue().onSucc("s");

        assertEquals("s", presenter.code);

    }
}


