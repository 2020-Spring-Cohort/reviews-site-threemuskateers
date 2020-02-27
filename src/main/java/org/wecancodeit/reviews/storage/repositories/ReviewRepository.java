package org.wecancodeit.reviews.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Movie;
import org.wecancodeit.reviews.models.Review;

import java.util.Collection;

public interface ReviewRepository extends CrudRepository<Review, Long> {

Collection<Review> findAllByMovie(Movie movie);


    Review findReviewByReviewId(Long reviewId);

    Collection<Review> findAllByHashtags(String hashtagName);




}
