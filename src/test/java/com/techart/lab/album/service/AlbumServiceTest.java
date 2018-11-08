package com.techart.lab.album.service;

import com.techart.lab.album.Album;
import com.techart.lab.album.dto.AlbumDto;
import com.techart.lab.album.repository.AlbumRepository;
import com.techart.lab.common.TestHelperUtils;
import com.techart.lab.common.exception.EntityNotFoundException;
import com.techart.lab.common.utils.ObjectMapper;
import com.techart.lab.song.dto.SongDto;
import com.techart.lab.song.service.SongService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit testing Service layer with Mockito and Hamcrest
 * @author vitali.pak
 */
@RunWith(MockitoJUnitRunner.class)
public class AlbumServiceTest {

    @InjectMocks
    private AlbumService albumService = new AlbumServiceImpl();

    @Mock
    private AlbumRepository albumRepository;

    @Mock
    private SongService songService;

    private AlbumDto albumDto;

    private Album album;

    private List<SongDto> songs;

    @Before
    public void setUp(){
        initSongs();
        initAlbumDto(songs);
        initAlbum();
    }

    @Test
    public void testGetByIdFound() {
        Long ALBUM_ID = 1L;

        when(albumRepository.findOne(ALBUM_ID)).thenReturn(album);

        assertThat(albumService.getById(ALBUM_ID), equalTo(albumDto));
    }

    @Test(expected=EntityNotFoundException.class)
    public void testGetByIdNotFound() {
        Long ALBUM_ID = 1L;

        when(albumRepository.findOne(ALBUM_ID)).thenReturn(null);

        albumService.getById(ALBUM_ID);
    }

    @Test
    public void testSaveAlbumAllSongsAreSaved (){
        when(albumRepository.save(any(Album.class))).thenReturn(new Album());

        albumService.saveAlbum(albumDto);

        verify(songService, times(1)).save(songs);

    }

    private void initAlbumDto(List<SongDto> songs){
        albumDto = AlbumDto.builder()
                .id(1L)
                .releaseDate(LocalDate.of(2007, Month.OCTOBER, 10))
                .title("In Rainbows")
                .songs(songs)
                .build();
    }

    private void initAlbum() {
        album = ObjectMapper.map(albumDto, Album.class);
    }

    private void initSongs() {
        songs = TestHelperUtils.buildSongsList();
    }

}
