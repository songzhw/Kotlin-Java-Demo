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

/*
java.util.GregorianCalendar
  [time=1554300334170,
  areFieldsSet=true,areAllFieldsSet=true,lenient=true,
  zone=sun.util.calendar.ZoneInfo[id="GMT",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],
  firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,
  YEAR=2019,MONTH=3,WEEK_OF_YEAR=14,WEEK_OF_MONTH=1,DAY_OF_MONTH=3,DAY_OF_YEAR=93,DAY_OF_WEEK=4,DAY_OF_WEEK_IN_MONTH=1,AM_PM=1,
  HOUR=2,HOUR_OF_DAY=14,MINUTE=5,SECOND=34,MILLISECOND=170,ZONE_OFFSET=0,DST_OFFSET=0]

 */