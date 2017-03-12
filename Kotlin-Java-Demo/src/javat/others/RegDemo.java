package javat.others;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by songzhw on 2017-03-11.
 */
public class RegDemo {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^#.*$");
        Matcher matcher = pattern.matcher("# TITLE01\n");
        boolean isMatched = matcher.matches();
        System.out.println("szw : isMatched = " + isMatched); //=> true
        System.out.println("======================");

        Pattern pattern2 = Pattern.compile(".*o");
        Matcher matcher2 = pattern2.matcher("zodocot");
        while (matcher2.find()) {
            String ret = matcher2.group(0);
            System.out.println(ret);//=> zo   do   co
        }
        System.out.println("======================");

        replace();
        System.out.println("======================");

        phone();
        System.out.println("======================");

        split();
        System.out.println("======================");

    }

    public static void replace() {
        String str = "<html>user</html>";
        String regex = "<html>|</html>";
        String newStr = "";
        String str2 = str.replaceAll(regex, newStr);
        System.out.println(str2);
    }

    public static void phone() {
        String phone = "0755-28792686";
        String regex = "\\d{3,4}-\\d{7,8}";
        boolean isPhone = phone.matches(regex);
        System.out.println("isPhone = " + isPhone);
    }

    public static void split() {
        final String REGEX = ":";
        final String INPUT = "one:two:three";

        Pattern p = Pattern.compile(REGEX);
        String[] items = p.split(INPUT);
        for (String s : items) {
            System.out.println(s);//=> one   two    three
        }
    }



}
