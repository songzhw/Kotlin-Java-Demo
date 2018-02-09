package time;

import java.time.LocalDate;

public class NewTimeDemo {
    public static void main(String[] args) {
        //LocalDate表示日期. 它只有日期, 不像java.util.Date一样有时间
        LocalDate today = LocalDate.now();
        System.out.println("today = " + today); //=> today = 2018-02-08
        System.out.println("year = " + today.getYear()); //=>2018.  (可以由LocalDate取到年, 月, 日)
        System.out.println("one day = " + LocalDate.parse("2018-02-02"));//string参的格式得左边所示
        LocalDate yuanDan = LocalDate.of(2018, 1, 1);
        System.out.println("one day = " + yuanDan);//=> one day = 2018-01-01
        System.out.println("equal? = " + (today.equals(yuanDan))); //=> false 日期的相等
       

    }
}
