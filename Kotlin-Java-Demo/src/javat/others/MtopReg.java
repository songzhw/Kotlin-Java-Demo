package javat.others;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MtopReg {
    public static void main(String[] args) {
        String url = "http://a.com/pic/0285/T1XXX_!!0-item_pic.jpg_90x90q90.jpg";
        String regex = "(\\S+)_(\\d+)x(\\d+)q(\\d+).(jpg|png)";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(url);
        boolean isMatched = matcher.matches();//=> true
        if (isMatched) {
            int gCount = matcher.groupCount(); //=> 5
            for (int i = 0; i <= gCount; i++) {
                String sg = matcher.group(i);
                System.out.println("sg(" + i + ") = " + sg);
            }
        }
        //=> sg(2) ： 90        ；    sg(3) : 90;    sg(4) : jpg
        //=> sg(1) : http://a.com/pic/0285/T1XXX_!!0-item_pic.jpg
        //=> sg(0) :　http://a.com/pic/0285/T1XXX_!!0-item_pic.jpg_90x90q90.jpg
    }
}
