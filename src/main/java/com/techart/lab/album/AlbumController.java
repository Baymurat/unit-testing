package com.techart.lab.album;

import com.techart.lab.album.dto.AlbumDto;
import com.techart.lab.album.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author by vitali.pak on 07.11.2018.
 */
@RestController
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/albums")
    public List<AlbumDto> allAlbums() {
        return albumService.getAllAlbums();
    }
}
