package com.pknu26.movie_mng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pknu26.movie_mng.dto.Movie;
import com.pknu26.movie_mng.dto.PageRequest;

@Mapper
public interface MovieMapper {
    List<Movie> getAllMovies();
    List<Movie> getMovieListWithPaging(PageRequest pageRequest);
    int getCount(PageRequest pageRequest);
    Movie getMovieById(Long movieId);
    void insertMovie(Movie movie);
    void updateMovie(Movie movie);
    void deleteMovie(Long movieId);
}
