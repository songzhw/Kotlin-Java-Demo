package ca.six.jold;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

class Temp {
  public static void main(String[] args) {
    System.out.println(8 | 1);
    System.out.println(Integer.valueOf(Integer.toBinaryString(8)));
//    System.out.println(Integer.valueOf(Double.toBinaryString(8.1)));

    System.out.println(2 + 1);    //=> 3
    System.out.println(2 + 0.1);  //=> 2.1
    System.out.println(0.2 + 0.1);//=> 0.30000000000000004

    System.out.println((0.1 + 0.2) + 0.3); //=> 0.6000000000000001
    System.out.println(0.1 + (0.2 + 0.3)); //=> 0.6
  }
}