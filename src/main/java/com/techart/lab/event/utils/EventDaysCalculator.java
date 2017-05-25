package com.techart.lab.event.utils;

import com.techart.lab.event.Event;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

/**
 * @author vitali.pak
 */
public class EventDaysCalculator {

    public static long calculateDaysTillEvent(Event event) {
        return calculateDaysTillEvent(event, Clock.system(ZoneOffset.UTC));
    }

    static long calculateDaysTillEvent(Event event, Clock clock) {
        LocalDate now = LocalDate.now(clock);
        long remainingDays = ChronoUnit.DAYS.between(now, event.getStartDate()) + 1;
        return remainingDays < 0 ? 0 : remainingDays;
    }
}
