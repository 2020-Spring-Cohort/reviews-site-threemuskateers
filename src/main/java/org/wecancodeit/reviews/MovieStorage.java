package org.wecancodeit.reviews;

public interface MovieStorage {

    void store(Movie movieToStore);

    Movie findMovieById(Long id);


}
