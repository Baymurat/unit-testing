package com.techart.lab.album.service;

import com.techart.lab.album.dto.AlbumDto;

import java.util.List;

/**
 * @author vitali.pak
 */
public interface AlbumService {

    AlbumDto getById(Long id);

    AlbumDto saveAlbum(AlbumDto updateDto);

    void deleteById(Long id);

    List<AlbumDto> getAllAlbums();

}
