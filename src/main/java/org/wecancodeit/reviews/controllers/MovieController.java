package org.wecancodeit.reviews.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.MovieStorage;

public class MovieController {
    private MovieStorage movieStorage;

    public MovieController(MovieStorage movieStorage) {
        this.movieStorage = movieStorage;
    }

    @RequestMapping("/categories/{id}")
    public String displayMovie() {
        return null;
    }
}
