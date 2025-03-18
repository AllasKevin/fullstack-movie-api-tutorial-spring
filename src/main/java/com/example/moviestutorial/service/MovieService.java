package com.example.moviestutorial.service;

import com.example.moviestutorial.model.Movie;
import com.example.moviestutorial.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies() {
        List<Movie> movies = movieRepository.findAll(); // ✅ Fetch only once

        movies.stream()
                .map(Movie::getTitle)
                .forEach(title -> System.out.println("Movie title: " + title)); // ✅ Print titles

        return movies; // ✅ Return the same list fetched
    }
}
