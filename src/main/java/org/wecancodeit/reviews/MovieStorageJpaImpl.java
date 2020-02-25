package org.wecancodeit.reviews;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

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


}
