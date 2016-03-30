package ca.six.demo;

import ca.six.demo.lib.mock.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * songzhw - 2016/3/31
 * Copyright 2016 Six.
 */
@RunWith(JUnit4.class)
public class MockitoOne {
    @Test
    public void testMockOne(){
        List list = Mockito.mock(ArrayList.class);
        when(list.get(0)).thenReturn(23);
        Assert.assertEquals(23, list.get(0));
    }

    @Test
    public void testMockClock(){
        DateTime my = Mockito.mock(DateTime.class);
        when(my.getNow()).thenReturn("2016-04-01");

//        Assert.assertEquals("2016-04-01", my.time);  //=> Error : Expected :2016-04-01 ;  Actual   :null
        Assert.assertEquals("2016-04-01", my.getNow());
    }

}
