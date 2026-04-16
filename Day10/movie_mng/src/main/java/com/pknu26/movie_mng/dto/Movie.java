package com.pknu26.movie_mng.dto;

import java.security.Timestamp;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Movie {
    private Long movieId;
    private String title;
    private String originalTitle;
    private String director;
    private String actors;
    private String genre;
    private LocalDate releaseDate;
    private Integer runningTime;
    private Double rating;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
