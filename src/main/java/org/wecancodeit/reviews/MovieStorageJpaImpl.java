package org.wecancodeit.reviews;

public class MovieStorageJpaImpl implements MovieStorage {


    private final MovieRepository movieRepository;

    public MovieStorageJpaImpl(MovieRepository movieRepo) {
        this.movieRepository = movieRepo;
    }

    @Override
    public void store(Movie movieToStore) {

    }

    @Override
    public Movie findMovieById(Long id) {
        return null;
    }
}
