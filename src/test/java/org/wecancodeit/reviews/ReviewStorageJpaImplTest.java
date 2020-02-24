package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ReviewStorageJpaImplTest {

    private ReviewRepository underTest;
    private Review testReview;
    private Movie testMovie;
    private Category testCategory;


    @Test
        public void shouldFindRevieByMovie(){
            underTest = mock(ReviewRepository.class);
            ReviewStorageJpaImpl testRepo = new ReviewStorageJpaImpl(underTest);
            testCategory = new Category("Comedy", "comedyPic");
            testMovie = new Movie("Out Cold", testCategory);
            testReview = new Review( testMovie, "Nadir");


            when(testRepo.findReviewsForMovie("Out Cold")).thenReturn(Collections.singletonList(testReview));
            testRepo.store(testReview);
            verify(underTest).save(testReview);
            assertThat(testRepo.findAllReviews()).contains(testReview);


        }

//        @Test
//        public void shouldStoreMovie(){
//            underTest = mock(MovieRepository.class);
//            underTest = new MovieStorageJpaImpl(underTest);
//            Category testCategory = new Category("Comedy", "comedyPic");
//            testReview = new Movie("Out Cold", testCategory);
//
//            underTest.store(testReview);
//            verify(underTest).save(testReview);
//    }
}
