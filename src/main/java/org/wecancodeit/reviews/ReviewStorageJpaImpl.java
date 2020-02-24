package org.wecancodeit.reviews;

import java.util.Collection;

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
        return (Collection<Review>) reviewRepository.findReviewsForMovie(movie).get();}
}
