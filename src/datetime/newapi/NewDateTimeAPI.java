package datetime.newapi;

import java.time.*;
import java.time.temporal.ChronoField;
import java.util.concurrent.TimeUnit;

public class NewDateTimeAPI {
    public static void main(String[] args) throws InterruptedException {
        // Use-case 1: Software renewal
        LocalDate expiryDate = LocalDate.now();
        //LocalDate expiryDate = LocalDate.of(2017, Month.JUNE, 30);
        System.out.println("expiryDate: " + expiryDate);
        LocalDate newExpiryDate = expiryDate.plusMonths(8);
        System.out.println("newExpiryDate: " + newExpiryDate);

        // Other methods: plus & minus methods, isBefore, isAfter

        System.out.println("\nyear: " + newExpiryDate.getYear());
        System.out.println("month: " + newExpiryDate.getMonth());
        System.out.println("day of month: " + newExpiryDate.getDayOfMonth()); // returns Month enum
        System.out.println("day of week: " + newExpiryDate.getDayOfWeek());
        System.out.println("Leap Year? " +	 newExpiryDate.isLeapYear());
        System.out.println("length of month: " + newExpiryDate.lengthOfMonth());

        // get returns an int
        System.out.println("year again: " + newExpiryDate.get(ChronoField.YEAR));
        System.out.println("month again: " + newExpiryDate.get(ChronoField.MONTH_OF_YEAR));
        System.out.println("day of month again: " + newExpiryDate.get(ChronoField.DAY_OF_MONTH));

        // parse string
        LocalDate epoch = LocalDate.parse("1970-01-01"); // yyyy-mm-dd
        System.out.println("epoch year: " + epoch.getYear());

        // Use-case 2: Game start time localized to time zone

        // LocalTime
        LocalTime time = LocalTime.of(9, 00, 00);
        System.out.println("\ntime -- hr: " + time.getHour());

        // LocalDate
        LocalDate gameStartDate = LocalDate.of(2017, Month.JULY, 03);

        // LocalDateTime
        LocalDateTime gameStartTime = LocalDateTime.of(gameStartDate, time);
        System.out.println("gameStartTime: " + gameStartTime);

        // TimeZone ==> ZoneId
        ZonedDateTime zonedGameStartTime = ZonedDateTime.of(gameStartTime, ZoneId.of("Europe/London"));
        System.out.println("zonedGameStartTime: " + zonedGameStartTime);

        ZonedDateTime indiaTime = zonedGameStartTime.withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
        System.out.println("indiaTime: " + indiaTime);

        ZonedDateTime pst = zonedGameStartTime.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
        System.out.println("pst: " + pst);

        // Use-Case 3: Age calculation (Period)

        LocalDate birthDay = LocalDate.of(1978, Month.JANUARY, 1);
        LocalDate today = LocalDate.now(); // current date from system clock
        Period period = birthDay.until(today);
        System.out.println("\nComplete Age: " + period.toString());
        System.out.println("Age: " + period.getYears());


        // Use-Case 4: Interval timing (Instant & Duration)

        Instant startTime = Instant.now();
        TimeUnit.SECONDS.sleep(2);
        Instant endTime = Instant.now();
        Duration timeElapsed =	 Duration.between(startTime, endTime);
        System.out.println("timeElapsed in ms: " + timeElapsed.toMillis());


        // Partial Classes
        System.out.println("Christmas: " + MonthDay.of(Month.DECEMBER, 25));
        System.out.println("Credit card expiry date: " + YearMonth.of(2017, Month.JULY));

        // Don't forget to check out the API
    }
}
