package org.wecancodeit.reviews;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review, Long> {

Collection<Review> findAllByMovie(Movie movie);


}
