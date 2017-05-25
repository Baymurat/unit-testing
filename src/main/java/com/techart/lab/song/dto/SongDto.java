package com.techart.lab.song.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vitali.pak
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SongDto {

    private Long id;

    private String title;

    private long duration;
}
