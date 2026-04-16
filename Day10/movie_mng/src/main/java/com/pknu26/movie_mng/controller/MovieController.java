package com.pknu26.movie_mng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pknu26.movie_mng.dto.Movie;
import com.pknu26.movie_mng.dto.PageRequest;
import com.pknu26.movie_mng.dto.PageResponse;
import com.pknu26.movie_mng.service.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

   @GetMapping
    public String list(@ModelAttribute PageRequest pageRequest, Model model) {
        PageResponse<Movie> response = movieService.readMovieList(pageRequest);
        
        model.addAttribute("response", response);
        model.addAttribute("movies", response.getDtoList());
        
        return "movie_list";
    }

    @GetMapping("/{id}")
    public String viewMovie(@PathVariable("id") Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        return "movie_detail";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movie_form";
    }

    @PostMapping("/add")
    public String addMovie(@ModelAttribute Movie movie) {
        movieService.addMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        return "movie_form";
    }

    @PostMapping("/edit")
    public String editMovie(@ModelAttribute Movie movie) {
        movieService.updateMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }
}
