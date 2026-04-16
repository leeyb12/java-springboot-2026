package com.pknu26.movie_mng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pknu26.movie_mng.dto.Movie;
import com.pknu26.movie_mng.dto.PageRequest;
import com.pknu26.movie_mng.dto.PageResponse;
import com.pknu26.movie_mng.mapper.MovieMapper;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<Movie> getAllMovies() {
        return movieMapper.getAllMovies();
    }

    @Override
    public Movie getMovieById(Long movieId) {
        return movieMapper.getMovieById(movieId);
    }

    @Override
    public void addMovie(Movie movie) {
        movieMapper.insertMovie(movie);
    }

    @Override
    public void updateMovie(Movie movie) {
        movieMapper.updateMovie(movie);
    }

    @Override
    public void deleteMovie(Long movieId) {
        movieMapper.deleteMovie(movieId);
    }

    @Override
    public PageResponse<Movie> readMovieList(PageRequest pageRequest) {
        List<Movie> dtoList = movieMapper.getMovieListWithPaging(pageRequest);
        
        int totalCount = movieMapper.getCount(pageRequest);

        return new PageResponse<>(dtoList, totalCount, pageRequest.getPage(), pageRequest.getSize());
    }
}
