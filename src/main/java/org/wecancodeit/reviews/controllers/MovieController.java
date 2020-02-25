package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.models.Movie;
import org.wecancodeit.reviews.storage.MovieStorage;

@Controller
public class MovieController {
    private MovieStorage movieStorage;


    public MovieController(MovieStorage movieStorage ) {
        this.movieStorage = movieStorage;

    }

    @RequestMapping("/movies/{title}")
    public String displayMovie(@PathVariable String title, Model model) {
        Movie retrievedMovie = movieStorage.findMovieByTitle(title);
        model.addAttribute("movie", retrievedMovie);
        return "single_movie";
    }
}
