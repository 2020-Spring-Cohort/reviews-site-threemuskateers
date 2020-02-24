package org.wecancodeit.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ReviewStorageJpaImpl {

    private ReviewRepository reviewRepository;

    public ReviewStorageJpaImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Collection<Review> findAllReviews(){
        return (Collection<Review>) reviewRepository.findAll();
    }

    public void store(Review review){
        reviewRepository.save(review);
    }

    public Collection<Review> findReviewsForMovie(String movie){
        return (Collection<Review>) reviewRepository.findReviewsForMovie(movie).get();
    }
}
