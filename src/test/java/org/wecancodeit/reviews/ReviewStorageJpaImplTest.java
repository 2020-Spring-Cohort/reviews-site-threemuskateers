package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Movie;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.repositories.ReviewRepository;
import org.wecancodeit.reviews.storage.ReviewStorageJpaImpl;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ReviewStorageJpaImplTest {

    private ReviewRepository underTest;
    private Review testReview;
    private Movie testMovie;
    private Category testCategory;
    private ReviewStorageJpaImpl testRepo;


    @Test
        public void shouldFindAllReviews(){
            underTest = mock(ReviewRepository.class);
            testRepo = new ReviewStorageJpaImpl(underTest);
            testCategory = new Category("Comedy", "comedyPic");
            testMovie = new Movie("Out Cold", testCategory);
            testReview = new Review(testMovie, "Nadir", 4, "funny");


            when(testRepo.findAllReviews()).thenReturn(Collections.singletonList(testReview));
            testRepo.store(testReview);
            verify(underTest).save(testReview);
            assertThat(testRepo.findAllReviews()).contains(testReview);

        }

    @Test
    public void shouldFindReviewsForMovie(){
        underTest = mock(ReviewRepository.class);
        testRepo = new ReviewStorageJpaImpl(underTest);
        testCategory = new Category("Comedy", "comedyPic");
        testMovie = new Movie("Out Cold", testCategory);
        testReview = new Review(testMovie, "Nadir", 5, "commenttt");

        testRepo.store(testReview);
        when(testRepo.findAllReviewsByMovie(testMovie)).thenReturn(Collections.singletonList(testReview));

        verify(underTest).save(testReview);
        assertThat(testRepo.findAllReviewsByMovie(testMovie)).contains(testReview);


    }
}
