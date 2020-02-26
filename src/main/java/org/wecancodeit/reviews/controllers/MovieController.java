package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Movie;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.MovieStorage;
import org.wecancodeit.reviews.storage.ReviewStorage;

@Controller
public class MovieController {
    private MovieStorage movieStorage;
    private ReviewStorage reviewStorage;

    public MovieController(MovieStorage movieStorage, ReviewStorage reviewStorage) {
        this.movieStorage = movieStorage;
        this.reviewStorage = reviewStorage;
    }

    @RequestMapping("/movies/{title}")
    public String displayMovie(@PathVariable String title, Model model) {
        Movie retrievedMovie = movieStorage.findMovieByTitle(title);
        model.addAttribute("movie", retrievedMovie);
        return "single_movie";
    }

    @PostMapping("/movies/{title}/add-review")
    public String addReview(@RequestParam String reviewTitle, int rating, String author, String summary, Model model, @PathVariable String title) {
        Movie movieFromReviewTitle = movieStorage.findMovieByTitle(reviewTitle);
        Review reviewToStore = new Review(movieFromReviewTitle, author, rating, summary);
        reviewStorage.store(reviewToStore);
//        model.addAttribute("title", reviewToStore);
        return "redirect:/movies/"+reviewTitle;
    }
}
