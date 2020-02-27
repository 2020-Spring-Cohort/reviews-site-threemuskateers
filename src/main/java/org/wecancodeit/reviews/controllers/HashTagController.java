package org.wecancodeit.reviews.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.repositories.HashtagRepository;
import org.wecancodeit.reviews.storage.repositories.ReviewRepository;

import java.util.Collection;
import java.util.Optional;

@Controller
public class HashTagController {

    private HashtagRepository hashtagRepository;
    private ReviewRepository reviewRepository;

    public HashTagController(HashtagRepository hashtagRepository, ReviewRepository reviewRepository) {
        this.hashtagRepository = hashtagRepository;
        this.reviewRepository = reviewRepository;
    }

    @RequestMapping({"/hashtags"})
    public String showAllHashtags(Model model){
        model.addAttribute("allHashtags", hashtagRepository.findAll());
        return "all-hashtags";
    }

    // /movies/hashtag/hashID
    @RequestMapping({"/hashtags/{hashtagName}"})
    public String showAllReviewsForHashtag(@PathVariable String hashtagName, Model model){
        Hashtag hashtagToDisplay = hashtagRepository.findHashtagByHashtag(hashtagName).get();
//        Collection<Review> reviewsFromHash = reviewRepository.findAllByHashtags(hashtagName);
        model.addAttribute("singleHashtag", hashtagToDisplay);
        return "reviews_hashtag";
    }
}
