package com.techart.lab.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author vitali.pak
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    private LocalDate startDate;

    private LocalDate endDate;

}
