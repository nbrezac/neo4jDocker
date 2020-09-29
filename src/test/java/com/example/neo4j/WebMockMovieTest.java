package com.example.neo4j;

import com.example.neo4j.controller.MovieController;
import com.example.neo4j.model.Movie;
import com.example.neo4j.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieController.class)
public class WebMockMovieTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MovieService movieService;

    @Test
    public void testGetAllMoviesWithFakeResponse() throws Exception {
        List<Movie> someMovieList = new ArrayList<>();
        Movie someMovie = new Movie();
        someMovie.setId((long) 1);
        someMovie.setTitle("Some title");
        someMovie.setReleased(1999);
        someMovie.setTagline("");
        someMovie.setPersons(null);
        someMovieList.add(someMovie);

        when(movieService.getAllMovies()).thenReturn(someMovieList);
        this.mockMvc.perform(get("/api/movie"))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Some title")));

    }

}
