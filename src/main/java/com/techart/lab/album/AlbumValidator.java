package com.techart.lab.album;

import org.apache.tomcat.jni.Local;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Month;

/**
 * @author by vitali.pak on 25.05.2017.
 */
public class AlbumValidator {

    private static final LocalDate EARLIEST_ALBUM_RELEASE_DATE = LocalDate.of(1948, Month.MAY, 25);

    public static boolean isReleaseDateValid(Album album, Clock clock) {
        LocalDate albumReleaseDate = album.getReleaseDate();
        return (EARLIEST_ALBUM_RELEASE_DATE.isBefore(albumReleaseDate) || EARLIEST_ALBUM_RELEASE_DATE.isEqual(albumReleaseDate))
                && (LocalDate.now(clock).isAfter(albumReleaseDate) || LocalDate.now(clock).isEqual(albumReleaseDate));
    }
}
