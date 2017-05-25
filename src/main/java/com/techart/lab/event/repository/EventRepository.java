package com.techart.lab.event.repository;

import com.techart.lab.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author vitali.pak
 */

public interface EventRepository extends JpaRepository<Event, Long> {
}
