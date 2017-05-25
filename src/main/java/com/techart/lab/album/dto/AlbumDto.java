package com.techart.lab.album.dto;

import com.techart.lab.song.dto.SongDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author vitali.pak
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDto {

    private Long id;

    private String title;

    private LocalDate releaseDate;

    private List<SongDto> songs;
}
