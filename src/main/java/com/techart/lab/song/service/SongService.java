package com.techart.lab.song.service;

import com.techart.lab.common.utils.ObjectMapper;
import com.techart.lab.song.Song;
import com.techart.lab.song.dto.SongDto;
import com.techart.lab.song.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author vitali.pak
 */
@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public void save(List<SongDto> songs) {
        songs.forEach(songDto -> songRepository.save(ObjectMapper.map(songDto, Song.class)));
    }
}
