package com.techart.lab.album.service;

import com.techart.lab.album.Album;
import com.techart.lab.album.dto.AlbumDto;
import com.techart.lab.album.repository.AlbumRepository;
import com.techart.lab.common.exception.EntityNotFoundException;
import com.techart.lab.common.utils.ObjectMapper;
import com.techart.lab.song.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author by vitali.pak on 25.05.2017.
 */
@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongService songService;

    @Override
    public AlbumDto getById(Long id) {
        Album album = albumRepository.findOne(id);
        return Optional.ofNullable(album).map(a -> ObjectMapper.map(a, AlbumDto.class))
                .orElseThrow(() -> new EntityNotFoundException(id, Album.class));
    }

    @Override
    public AlbumDto saveAlbum(AlbumDto updateAlbumDto) {
        Album album = albumRepository.save(ObjectMapper.map(updateAlbumDto, Album.class));
        songService.save(updateAlbumDto.getSongs());
        return ObjectMapper.map(album, AlbumDto.class);
    }

    @Override
    public void deleteById(Long id) {
        albumRepository.delete(id);
    }
}
