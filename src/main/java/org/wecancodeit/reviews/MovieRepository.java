package org.wecancodeit.reviews;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    Optional<Movie> findById(Long id);
}
