package com.techart.lab.event.service;

import com.techart.lab.common.TestHelperUtils;
import com.techart.lab.event.Event;
import com.techart.lab.event.dto.EventDto;
import com.techart.lab.event.repository.EventRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author vitali.pak
 */
@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

       /* This is another way to initialize mocks.
        In case if you need to use another test runner (You can't use multiple test runners)

        @Before
        public void initMocks() {
            MockitoAnnotations.initMocks(this);
        }

       */

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventServiceImpl eventService;

    @Test
    public void testGetById() {
        Long EVENT_ID = 1L;
        Event eventFromRepository = TestHelperUtils.buildTestEvent();
        EventDto expectedServiceResult = EventDto.builder()
                .startDate(LocalDate.of(2017, Month.MAY, 29))
                .endDate(LocalDate.of(2017, Month.MAY, 31))
                .build();
        when(eventRepository.findOne(EVENT_ID)).thenReturn(eventFromRepository);

        EventDto eventDto = eventService.getById(EVENT_ID);

        verify(eventRepository, times(1)).findOne(EVENT_ID);
        assertThat(expectedServiceResult, equalTo(eventDto));
    }

}
