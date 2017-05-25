package com.techart.lab.event.service;

import com.techart.lab.common.utils.ObjectMapper;
import com.techart.lab.event.Event;
import com.techart.lab.event.dto.EventDto;
import com.techart.lab.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vitali.pak
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public EventDto getById(Long id) {
        Event thatEvent = eventRepository.findOne(id);
        return ObjectMapper.map(thatEvent, EventDto.class);
    }
}
