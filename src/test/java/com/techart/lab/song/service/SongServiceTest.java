package com.techart.lab.song.service;

import com.techart.lab.common.TestHelperUtils;
import com.techart.lab.song.Song;
import com.techart.lab.song.dto.SongDto;
import com.techart.lab.song.repository.SongRepository;
import com.techart.lab.song.service.SongService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Example of using Hamcrest matcher to check that result list contains certain elements.
 * @author vitali.pak
 */
@RunWith(MockitoJUnitRunner.class)
public class SongServiceTest {

    @InjectMocks
    private SongService songService;

    @Mock
    private SongRepository songRepository;

    @Test
    public void testSaveCorrectSongs() {
        List<SongDto> songs = TestHelperUtils.buildSongsList();

        songService.save(songs);

        ArgumentCaptor<Song> songCapture = ArgumentCaptor.forClass(Song.class);
        verify(songRepository, times(3)).save(songCapture.capture());

        assertThat(songCapture.getAllValues(),
                hasItems(Song.builder().title("All I Need").duration(229L).build(),
                        Song.builder().title("Videotape").duration(280L).build(),
                        Song.builder().title("Reckoner").duration(229L).build()));

    }
}
