package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Movie;

public interface MovieStorage {

    void store(Movie movieToStore);

    Movie findMovieById(Long id);

    Movie findMovieByTitle(String title);

}
