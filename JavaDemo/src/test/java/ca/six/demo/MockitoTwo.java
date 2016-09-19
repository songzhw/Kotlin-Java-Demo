package ca.six.demo;

import ca.six.demo.lib.mock.MyCounter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(JUnit4.class)
public class MockitoTwo {

    @Test
    public void testMyCounter(){
        List mockedList = mock(List.class);
        mockedList.add("111");
        mockedList.add("222");

        MyCounter counter = new MyCounter();
        int count = counter.count(mockedList); // Error : java.lang.NullPointerException
        assertEquals(count, 2);
    }
}