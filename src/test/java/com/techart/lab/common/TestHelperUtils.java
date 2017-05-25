package com.techart.lab.common;

import com.techart.lab.event.Event;
import com.techart.lab.song.dto.SongDto;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

/**
 * @author vitali.pak
 */
public class TestHelperUtils {

    public static Event buildTestEvent() {
        return Event.builder()
                .startDate(LocalDate.of(2017, Month.MAY, 29))
                .endDate(LocalDate.of(2017, Month.MAY, 31))
                .build();
    }

    public static List<SongDto> buildSongsList() {
        return Arrays.asList(
                SongDto.builder().title("All I Need").duration(229L).build(),
                SongDto.builder().title("Videotape").duration(280L).build(),
                SongDto.builder().title("Reckoner").duration(229L).build()
        );
    }
}
