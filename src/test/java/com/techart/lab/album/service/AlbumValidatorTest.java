package com.techart.lab.album.service;

import com.techart.lab.album.Album;
import com.techart.lab.album.AlbumValidator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.apache.tomcat.jni.Local;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.*;

import static org.junit.Assert.assertEquals;

/**
 * @author by vitali.pak
 */
@RunWith(JUnitParamsRunner.class)
public class AlbumValidatorTest {

    @Test
    @Parameters(method = "albumReleaseDateTestValues")
    public void isAlbumReleaseDateValid(Album album, LocalDate currentDate, boolean valid) throws Exception {

        Instant currentInstant = currentDate.atStartOfDay().toInstant(ZoneOffset.UTC);
        Clock testClocks = Clock.fixed(currentInstant, ZoneOffset.UTC);

        assertEquals(AlbumValidator.isReleaseDateValid(album, testClocks), valid);
    }

    private Object[] albumReleaseDateTestValues() {
        return new Object[]{
                new Object[]{new Album(LocalDate.of(2018, Month.MAY, 8)), LocalDate.of(2017,Month.MAY, 23), false},
                new Object[]{new Album(LocalDate.of(2017, Month.MAY, 8)), LocalDate.of(2017,Month.MAY, 8), true},
                new Object[]{new Album(LocalDate.of(1948, Month.MAY, 25)), LocalDate.of(2017,Month.MAY, 25), true},
                new Object[]{new Album(LocalDate.of(2017, Month.MAY, 8)), LocalDate.of(2017,Month.MAY, 25), true},
        };
    }

    private Object[] parametersForIsAlbumReleaseDateValid() {
        return new Object[]{
                new Object[]{new Album(LocalDate.of(2018, Month.MAY, 8)), LocalDate.of(2017,Month.MAY, 23), false},
                new Object[]{new Album(LocalDate.of(2017, Month.MAY, 8)), LocalDate.of(2017,Month.MAY, 8), true},
                new Object[]{new Album(LocalDate.of(1948, Month.MAY, 25)), LocalDate.of(2017,Month.MAY, 25), true},
                new Object[]{new Album(LocalDate.of(2017, Month.MAY, 8)), LocalDate.of(2017,Month.MAY, 25), true},
        };
    }
}
