package com.techart.lab.song.repository;

import com.techart.lab.song.Song;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author vitali.pak
 */
public interface SongRepository extends JpaRepository<Song, Long> {
}
