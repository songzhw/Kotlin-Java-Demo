package ca.six.demo.rule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RuleDemoUnitTest {
    @Rule
    public MethodNameExample methodNameExample = new MethodNameExample();

    @Before
    public void setup(){
        System.out.println("szw @Before setup()");
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void mulitiplication_isCorrect() throws Exception {
        assertEquals(4, 2 * 2);
    }
}