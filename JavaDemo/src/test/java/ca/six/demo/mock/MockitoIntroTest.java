package ca.six.demo.mock;

import ca.six.demo.lib.mock.MockitoIntroduction;
import ca.six.demo.lib.mock.MyString;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by songzhw on 2016-09-28.
 */
public class MockitoIntroTest {
    private MockitoIntroduction obj;

    @Before
    public void setUp(){
        obj = new MockitoIntroduction();
    }

    @Test
    public void testAdd(){
        MockitoIntroduction obj = new MockitoIntroduction();
        int actual = obj.add(4, 2);
        assertEquals(6, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void testDivideWithException(){
        MockitoIntroduction instance = mock(MockitoIntroduction.class);
        when(instance.divide(10, 2)).thenThrow(new IllegalStateException("error!"));
        instance.divide(10, 2);
    }

    @Test
    public void testPrint(){
        MyString mockStr = mock(MyString.class);
        obj.print(mockStr);
        verify(mockStr).print();
    }
}
