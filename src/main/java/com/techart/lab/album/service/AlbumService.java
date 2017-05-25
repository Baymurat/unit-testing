package com.techart.lab.album.service;

import com.techart.lab.album.dto.AlbumDto;

/**
 * @author vitali.pak
 */
public interface AlbumService {

    AlbumDto getById(Long id);

    AlbumDto saveAlbum(AlbumDto updateDto);

    void deleteById(Long id);

}
