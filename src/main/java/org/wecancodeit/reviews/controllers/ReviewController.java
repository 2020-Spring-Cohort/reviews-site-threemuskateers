package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.Review;
import org.wecancodeit.reviews.ReviewRepository;
@Controller
public class ReviewController {
    private ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {

        this.reviewRepository = reviewRepository;
    }
    @RequestMapping("/movies/{reviewId}")
    public String displayReview(@PathVariable Long reviewId, Model model) {
        Review retrievedReview = reviewRepository.findReviewById(reviewId);
        model.addAttribute("review", retrievedReview);
        return "single_review";
    }
}
