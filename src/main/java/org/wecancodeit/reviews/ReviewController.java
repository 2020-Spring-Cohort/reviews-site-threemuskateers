package org.wecancodeit.reviews;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class ReviewController {
    private ReviewStorage reviewStorage;

    public ReviewController(ReviewStorage reviewStorage) {

        this.reviewStorage = reviewStorage;
    }
    @RequestMapping("/movies/{reviewId}")
    public String displayReview(@PathVariable Long reviewId, Model model) {
        return "single_review";
    }
}
