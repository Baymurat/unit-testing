package com.techart.lab.album.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techart.lab.album.AlbumController;
import com.techart.lab.album.dto.AlbumDto;
import com.techart.lab.album.service.AlbumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.when;

/**
 * Unit testing Spring MVC controllers with MockMVC library
 * @author by vitali.pak on 07.11.2018.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AlbumController.class)
public class AlbumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlbumService albumService;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        List<AlbumDto> testAlbums = Arrays.asList(
                AlbumDto.builder().id(1L).releaseDate(LocalDate.of(2007, Month.OCTOBER, 10)).title("In Rainbows").build(),
                AlbumDto.builder().id(2L).releaseDate(LocalDate.of(20016, Month.MAY, 8)).title("A Moon Shaped Pool").build()
        );

        when(albumService.getAllAlbums()).thenReturn(testAlbums);

        this.mockMvc
                .perform(get("/albums"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(convertObjectToJson(testAlbums)));
    }

    private String convertObjectToJson(Object value) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(value);
    }

}
