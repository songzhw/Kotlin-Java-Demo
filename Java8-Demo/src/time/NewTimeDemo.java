package time;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import javax.sound.midi.Soundbank;

public class NewTimeDemo {
    public static void main(String[] args) {
        //LocalDate表示日期. 它只有日期, 不像java.util.Date一样有时间
        LocalDate today = LocalDate.now();
        System.out.println("today = " + today); //=> today = 2018-02-08
        System.out.println("tomorrow = "+today.plusDays(1));//=> tomorrow = 2018-02-09
        System.out.println("after one week = "+today.plus(1, ChronoUnit.WEEKS)); //=> after one week = 2018-02-15

        System.out.println("year = " + today.getYear()); //=>2018.  (可以由LocalDate取到年, 月, 日)
        System.out.println("one day = " + LocalDate.parse("2018-02-02"));//string参的格式可以设置为parse()的第二参
        LocalDate yuanDan = LocalDate.of(2018, 1, 1);
        System.out.println("one day = " + yuanDan);//=> one day = 2018-01-01

        System.out.println("equal? = " + (today.equals(yuanDan))); //=> false 日期的相等
        System.out.println("before? = "+(today.isBefore(yuanDan))); //=> false

        //LocalTime表示时间. 仍是只有时间(时, 分, 秒), 没有日期哦
        LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours(3);
        System.out.println("三个小时后的时间 = "+newTime);//=> 12:36:37.719
        System.out.println("三分钟前是 = "+time.minus(3, ChronoUnit.MINUTES));


        // Clock类表示时间戳. 可以替代System.currentTimeInMillis()和TimeZone.getDefault()
        Clock clock = Clock.systemUTC(); // Returns the current time based on your system clock and set to UTC.
        System.out.println("Clock : " + clock.millis()); //=>1518100917811

        Clock defaultClock = Clock.systemDefaultZone(); // Returns time based on system clock zone
        System.out.println("Clock : " + defaultClock.millis());  //=> 1518100917811

        // Instant也是表示时间戳
        System.out.println("time stamp = "+ Instant.now().toEpochMilli());//=> 1518100917811

        // ZoneId; ZoneDateTime处理某时区下的时间; (替代了以前的GregorianCalendar类了)
        ZoneId sh = ZoneId.of("Asia/Shanghai");
        LocalDateTime now2 = LocalDateTime.now(); //=> Toronto = 2018-02-08T09:50:33.768
        ZonedDateTime timeInSh  = ZonedDateTime.of(now2, sh );
        System.out.println("Shanghai = " + timeInSh); //=> Shanghai = 2018-02-08T09:50:33.768+08:00[Asia/Shanghai]
        // szw: 时区计算有误?

        // 信用卡的expiry time是"月/年"的形式. 在java8中是用YearMonth类
        System.out.println("expired = "+ YearMonth.of(2019, Month.MARCH)); //=> expired = 2019-03

        // 闰年
        System.out.println("leapYear? = "+LocalDate.now().isLeapYear()); //=> false

        // 计算2个日子间的天数, 周数, 月数
        LocalDate java8Release = LocalDate.of(2018, 12, 14);
        Period gap = Period.between(today, java8Release);
        System.out.println("gap = "+gap.getMonths()); //=> 10
    }
}


