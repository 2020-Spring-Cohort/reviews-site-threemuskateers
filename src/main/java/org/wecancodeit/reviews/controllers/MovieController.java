package org.wecancodeit.reviews.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.Movie;
import org.wecancodeit.reviews.MovieStorage;

public class MovieController {
    private MovieStorage movieStorage;

    public MovieController(MovieStorage movieStorage) {
        this.movieStorage = movieStorage;
    }

    @RequestMapping("/categories/genre/{id}")
    public String displayMovie(@PathVariable Long id, Model model) {
        Movie retrievedMovie = movieStorage.findMovieById(id);
        model.addAttribute("test movie", retrievedMovie);
        return "single_movie";
    }
}
