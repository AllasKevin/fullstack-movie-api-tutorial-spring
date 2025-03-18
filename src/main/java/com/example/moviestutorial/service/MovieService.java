package com.example.moviestutorial.service;

import com.example.moviestutorial.model.Movie;
import com.example.moviestutorial.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
