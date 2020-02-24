package org.wecancodeit.reviews;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.controllers.CategoriesController;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ReviewControllerTest {
    private MockMvc mockMvc;
    private Model mockModel;

    private ReviewController underTest;
    private ReviewStorage mockStorage;
    private Movie testMovie;
    private Review reviewUndertest;

    @BeforeEach
    public void setUp() {
        mockModel = mock(Model.class);
        mockStorage = mock(ReviewStorage.class);
        underTest = new ReviewController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        Category fakeCategory = new Category("Fake Category", "image");
        testMovie = new Movie("Out Cold", fakeCategory);
        reviewUndertest = new Review(testMovie, "Nadir");


    }
    @Test
    public void shouldFindReviewsEndpoint() {
        String result = underTest.displayReview(1L, mockModel);
        when(mockStorage.findReviewById(1L)).thenReturn(reviewUndertest);
        assertThat(result).isEqualTo("single_review");
    }
}
