package org.wecancodeit.reviews;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.controllers.ReviewController;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Movie;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.repositories.HashtagRepository;
import org.wecancodeit.reviews.storage.repositories.ReviewRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ReviewControllerTest {
    private MockMvc mockMvc;
    private Model mockModel;

    private ReviewController underTest;
    private ReviewRepository mockStorage;
    private Movie testMovie;
    private Review reviewUndertest;
    private HashtagRepository hashTagRepo;

    @BeforeEach
    public void setUp() {
        mockModel = mock(Model.class);
        mockStorage = mock(ReviewRepository.class);

        underTest = new ReviewController(mockStorage, hashTagRepo);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        Category fakeCategory = new Category("Fake Category", "image");
        testMovie = new Movie("Out Cold", fakeCategory);
        reviewUndertest = new Review(testMovie, "Nadir", 5, "it was ok from nadir");
    }
    @Test
    public void shouldFindReviewsEndpoint() {
        when(mockStorage.findById(1L)).thenReturn(Optional.of(reviewUndertest));
        String result = underTest.displayReview(1L, mockModel);
        assertThat(result).isEqualTo("single_review");
    }
    @Test
    public void shouldBeAbletoRetrieveSingleReview(){
        when(mockStorage.findById(1L)).thenReturn(Optional.of(reviewUndertest));
        underTest.displayReview(1L, mockModel);
        verify(mockStorage).findById(1L);
        verify(mockModel).addAttribute("review", reviewUndertest);
    }
    @Test
    public void displayReviewMappingIsCorrect()throws Exception{
        when(mockStorage.findById(1L)).thenReturn(Optional.of(reviewUndertest));
        mockMvc.perform(MockMvcRequestBuilders.get("/reviews/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("single_review"))
                .andExpect(model().attributeExists("review"))
                .andExpect(model().attribute("review", reviewUndertest));
    }
}
