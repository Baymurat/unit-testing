package com.techart.lab.album;

import com.techart.lab.song.Song;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * @author vitali.pak
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Album {

    private Long id;

    private String title;

    private LocalDate releaseDate;

    private List<Song> songs;

    public boolean isOld() {
        return LocalDate.of(1980, Month.DECEMBER, 11).isBefore(this.releaseDate);
    }

    public Album(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
