package com.techart.lab.event.service;

import com.techart.lab.event.dto.EventDto;

/**
 * @author vitali.pak
 */
public interface EventService {

    EventDto getById(Long id);

}
