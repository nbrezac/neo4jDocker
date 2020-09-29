package com.example.neo4j.service;

import com.example.neo4j.model.Movie;
import com.example.neo4j.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {


    @Autowired
    private MovieRepository movieRepository;


    public List<Movie> getAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

}
