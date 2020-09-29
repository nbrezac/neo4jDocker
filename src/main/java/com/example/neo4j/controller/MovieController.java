package com.example.neo4j.controller;

import com.example.neo4j.model.Movie;
import com.example.neo4j.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public @ResponseBody List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

}
