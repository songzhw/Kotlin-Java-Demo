package javat.others;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by songzhw on 2017-03-11.
 */
public class RegDemo {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^#.*$");
        Matcher matcher = pattern.matcher("# TITLE01\ntest");
        boolean isMatched = matcher.matches();
        System.out.println("szw : isMatched = "+isMatched);
    }
}
