package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.Category;
import org.wecancodeit.reviews.Movie;
import org.wecancodeit.reviews.MovieStorage;

@Controller
public class MovieController {
    private MovieStorage movieStorage;

    public MovieController(MovieStorage movieStorage) {
        this.movieStorage = movieStorage;
    }

    @RequestMapping("movies/{id}")
    public String displayMovie(@PathVariable long id, Model model) {
        Movie retrievedMovie = movieStorage.findMovieById(id);
        model.addAttribute("movie", retrievedMovie);
        return "single_movie";
    }
}
