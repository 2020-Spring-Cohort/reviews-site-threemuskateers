package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.repositories.HashtagRepository;
import org.wecancodeit.reviews.storage.repositories.ReviewRepository;

import java.util.Optional;

@Controller
public class ReviewController {
    private ReviewRepository reviewRepository;
    private HashtagRepository hashTagRepo;


    public ReviewController(ReviewRepository reviewRepository, HashtagRepository hashTagRepo) {
        this.reviewRepository = reviewRepository;

        this.hashTagRepo = hashTagRepo;
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
    @PostMapping("/reviews/{reviewId}/add-hashtag")
    public String addHashtagToReview(@RequestParam String hashTag, @PathVariable Long reviewId){
        Hashtag hashTagToAddToReview;
        Optional<Hashtag> hashTagToAddOpt = hashTagRepo.findHashtagByHashtag(hashTag);
        if(hashTagToAddOpt.isEmpty()){
            hashTagToAddToReview = new Hashtag(hashTag);
            hashTagRepo.save(hashTagToAddToReview);
        }else{
            hashTagToAddToReview = hashTagToAddOpt.get();
        }
        Review reviewToAddHashtagTo = reviewRepository.findReviewByReviewId(reviewId);
        reviewToAddHashtagTo.addHashtag(hashTagToAddToReview);
        reviewRepository.save(reviewToAddHashtagTo);
        return "redirect:/reviews/"+ reviewId;
    }

}
