package com.techart.lab.event.utils;

import com.techart.lab.common.TestHelperUtils;
import com.techart.lab.event.Event;
import org.junit.Before;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneOffset;

import static org.junit.Assert.assertEquals;

/**
 * @author vitali.pak
 */
public class EventDaysCalculatorTest {

    private Event event;

    @Before
    public void setUp() {
        initEvent();
    }

    private void initEvent() {
        this.event = TestHelperUtils.buildTestEvent();
    }

    @Test
    public void testCorrectDaysTillEvent() {
        long EXPECTED_AMOUNT_OF_DAYS = 5;
        Instant currentDate = LocalDate.of(2017, Month.MAY, 25)
                .atStartOfDay().toInstant(ZoneOffset.UTC);
        Clock testClocks = Clock.fixed(currentDate, ZoneOffset.UTC);

        long actualAmountOfDays = EventDaysCalculator.calculateDaysTillEvent(event, testClocks);

        assertEquals(EXPECTED_AMOUNT_OF_DAYS, actualAmountOfDays);

        // Hamcrest matcher
        // assertThat(actualAmountOfDays, equalTo(EXPECTED_AMOUNT_OF_DAYS));
    }
}
