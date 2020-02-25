package org.wecancodeit.reviews.storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.models.Movie;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.repositories.ReviewRepository;

import java.util.Collection;

@Service
public class ReviewStorageJpaImpl implements ReviewStorage {

    private ReviewRepository reviewRepository;

    public ReviewStorageJpaImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Collection<Review> findAllReviews(){
        return (Collection<Review>) reviewRepository.findAll();
    }

    @Override
    public void store(Review review) {
        reviewRepository.save(review);
    }

    public Collection<Review> findAllReviewsByMovie(Movie movie) {
        return (Collection <Review>) reviewRepository.findAllByMovie(movie);
    }



}
