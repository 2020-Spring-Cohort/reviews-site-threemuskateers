package org.wecancodeit.reviews;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    Review findReviewById(long id);

    Optional<Movie> findReviewsForMovie(String movie);
}
