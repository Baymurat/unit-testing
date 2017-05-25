package com.techart.lab.song;

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
public class Song {

    private Long id;

    private Long albumId;

    private String title;

    private long duration;
}
