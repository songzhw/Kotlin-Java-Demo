package ca.six.demo.lib.time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Ca2Cn {
    public static void main(String[] args) throws Exception {
/*        String[] zones = TimeZone.getAvailableIDs();
        for(String s : zones){
            System.out.println("szw time zone = "+s);
        }*/

        String dateCn = "20170717 9:00";
        SimpleDateFormat formatCn = new SimpleDateFormat("yyyyMMdd HH:mm");
        formatCn.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));

        Date dateCa = formatCn.parse(dateCn);
        SimpleDateFormat formatCa = new SimpleDateFormat("yyyyMMdd HH:mm");
        formatCa.setTimeZone(TimeZone.getTimeZone("Canada/Eastern"));
        String timeCa = formatCa.format(dateCa);
        System.out.println("szw ca : "+timeCa); //=> 20170716 21:00

    }
}
