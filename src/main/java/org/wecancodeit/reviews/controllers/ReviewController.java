package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.repositories.ReviewRepository;

@Controller
public class ReviewController {
    private ReviewRepository reviewRepository;


    public ReviewController(ReviewRepository reviewRepository ) {
        this.reviewRepository = reviewRepository;

    }
    @RequestMapping("/reviews/{reviewId}")
    public String displayReview( @PathVariable long reviewId, Model model) {
        Review retrievedReview = reviewRepository.findById(reviewId).get();
        model.addAttribute("review", retrievedReview);
        return "single_review";
    }

    @RequestMapping("/reviews")
    public String displayReview(Model model) {
        model.addAttribute("reviews", reviewRepository.findAll());
        return "reviews_multiple";
    }

}
