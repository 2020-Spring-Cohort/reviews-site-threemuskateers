package org.wecancodeit.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

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
