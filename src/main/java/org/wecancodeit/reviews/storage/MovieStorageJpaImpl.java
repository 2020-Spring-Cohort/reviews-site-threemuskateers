package org.wecancodeit.reviews.storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.models.Movie;
import org.wecancodeit.reviews.storage.repositories.MovieRepository;

@Service
public class MovieStorageJpaImpl implements MovieStorage {


    private final MovieRepository movieRepository;

    public MovieStorageJpaImpl(MovieRepository movieRepo) {
        this.movieRepository = movieRepo;
    }

    @Override
    public void store(Movie movieToStore) {
        movieRepository.save(movieToStore);
    }

    @Override
    public  Movie findMovieById(Long id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public Movie findMovieByTitle(String title) {
        return movieRepository.findMovieByTitle(title);
    }


}
