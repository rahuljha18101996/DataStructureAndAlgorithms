package datetime.legacy;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/*
 *
 * Commonly used classes
 * java.util.Date
 * java.util.Calendar
 * java.util.GregorianCalendar
 * java.util.TimeZone
 *
 *
 * Date date = new Date(116,5,8)
 * Starting point is 1900
 * So above date is June 8th, 2016
 * Month -> 0,11
 * Not thread safe
 *
 * */
public class LegacyDateTimeAPI {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());

        Calendar expiryDate = new GregorianCalendar(2022,8,4);
        System.out.println(expiryDate.getTime());
        expiryDate.add(Calendar.MONTH,9);
        expiryDate.roll(Calendar.MONTH,9);
        System.out.println(expiryDate.getTime());

//        var timeZones = TimeZone.getAvailableIDs();
//        for (String s : timeZones) {
//            System.out.println(s);
//        }

        Calendar c = new GregorianCalendar(TimeZone.getTimeZone("Europe/Athens"));
        c.set(2017,Calendar.JANUARY,3,9,0);
        System.out.println(c.getTime());
    }
}
