package com.merryyou.java8;

import java.time.*;

/**
 * Created on 2016/5/28 0028.
 *
 * @author zlf
 * @since 1.0
 */
public class ClockTest {
    public static void main(String[] args) {
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());

        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now(clock);
        System.out.println(date);
        System.out.println(dateFromClock);

        final LocalTime time = LocalTime.now();
        final LocalTime timeFromClock = LocalTime.now(clock);
        System.out.println(time);
        System.out.println(timeFromClock);

        final LocalDateTime dateTime = LocalDateTime.now();
        final LocalDateTime dataTimeFromClock = LocalDateTime.now(clock);
        System.out.println(dateTime);
        System.out.println(dataTimeFromClock);

        final ZonedDateTime zonedDateTime = ZonedDateTime.now();
        final ZonedDateTime zonedDateTimeFromClock = zonedDateTime.now(clock);
        final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now( ZoneId.of( "America/Los_Angeles" ) );
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTimeFromClock);
        System.out.println(zonedDatetimeFromZone);

        final LocalDateTime from = LocalDateTime.of(2014,Month.APRIL,16,0,0,0);
        final LocalDateTime to = LocalDateTime.of(2015,Month.APRIL,16,23,59,59);
        final Duration duration = Duration.between(from,to);
        System.out.println( "Duration in days: " + duration.toDays() );
        System.out.println( "Duration in hours: " + duration.toHours() );
    }
}
