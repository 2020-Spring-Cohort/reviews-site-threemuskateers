package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class MovieStorageJpaImplTest {
    private MovieRepository movieRepository;
    private MovieStorage underTest;
    private Movie outCold;

    @Test
    public void shouldFindMovieById(){
        movieRepository = mock(MovieRepository.class);
        underTest = new MovieStorageJpaImpl(movieRepository);
        Category testCategory = new Category("Comedy", "comedyPic");
        outCold = new Movie("Out Cold", testCategory);

        when(movieRepository.findById(1L)).thenReturn(Optional.of(outCold));
        Movie retrievedMovie = underTest.findMovieById(1L);

        assertThat(retrievedMovie).isEqualTo(outCold);

    }

    @Test
    public void shouldStoreMovie(){
        movieRepository = mock(MovieRepository.class);
        underTest = new MovieStorageJpaImpl(movieRepository);
        Category testCategory = new Category("Comedy", "comedyPic");
        outCold = new Movie("Out Cold", testCategory);

        underTest.store(outCold);
        verify(movieRepository).save(outCold);
    }
}
