package com.techart.lab.album.repository;

import com.techart.lab.album.Album;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author vitali.pak
 */
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
