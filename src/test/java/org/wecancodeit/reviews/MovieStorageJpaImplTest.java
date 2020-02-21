package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class MovieStorageJpaImplTest {
    private MovieRepository movieRepository;
    private MovieStorage underTest;
    private Movie movie;

    @Test
    public void shouldFindMovieById(){
        movieRepository = mock(MovieRepository.class);
        underTest = new MovieStorageJpaImpl(movieRepository);

    }
}
