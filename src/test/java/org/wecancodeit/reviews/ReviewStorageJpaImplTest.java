package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ReviewStorageJpaImplTest {

        private ReviewRepository underTest;
        private Review testReview;
    private Movie testMovie;

    @Test
        public void shouldFindMovieById(){
            underTest = mock(ReviewRepository.class);
            Category testCategory = new Category("Comedy", "comedyPic");
            testMovie = new Movie("Out Cold", testCategory);
            testReview = new Review( testMovie, "Nadir");

            when(underTest.findById(1L)).thenReturn(Optional.of(testReview));
            Movie retrievedMovie = underTest.findMovieById(1L);

            assertThat(retrievedMovie).isEqualTo(testReview);

        }

        @Test
        public void shouldStoreMovie(){
            underTest = mock(MovieRepository.class);
            underTest = new MovieStorageJpaImpl(underTest);
            Category testCategory = new Category("Comedy", "comedyPic");
            testReview = new Movie("Out Cold", testCategory);

            underTest.store(testReview);
            verify(underTest).save(testReview);
    }
}
