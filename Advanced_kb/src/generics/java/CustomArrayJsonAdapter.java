package generics.java;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CustomArrayJsonAdapter<T> {
    public void test1(String s1){
        T item = (T) s1;
    }
}
