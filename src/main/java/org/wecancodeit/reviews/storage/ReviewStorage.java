package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Review;

import java.util.Collection;

public interface ReviewStorage {

    Collection<Review> findAllReviews();

    void store(Review review);



}
