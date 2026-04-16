package com.pknu26.movie_mng.service;

import java.util.List;

import com.pknu26.movie_mng.dto.Movie;
import com.pknu26.movie_mng.dto.PageRequest;
import com.pknu26.movie_mng.dto.PageResponse;

public interface MovieService {
    List<Movie> getAllMovies();
    PageResponse<Movie> readMovieList(PageRequest pageRequest);
    Movie getMovieById(Long movieId);
    void addMovie(Movie movie);
    void updateMovie(Movie movie);
    void deleteMovie(Long movieId);
}
