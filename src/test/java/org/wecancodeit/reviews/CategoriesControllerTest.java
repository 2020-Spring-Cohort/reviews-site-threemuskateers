package org.wecancodeit.reviews;

import org.springframework.ui.Model;
import org.wecancodeit.reviews.controllers.CategoriesController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Movie;
import org.wecancodeit.reviews.storage.CategoryStorage;
import org.wecancodeit.reviews.storage.MovieStorage;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


public class CategoriesControllerTest {

    private CategoriesController underTest;
    private CategoryStorage mockStorage;
    private MovieStorage movieStorage;
    private Category testCategory;

    private MockMvc mockMvc;
    private Model mockModel;

    @BeforeEach
    public void setUp() {
        mockModel = mock(Model.class);
        movieStorage = mock(MovieStorage.class);
        mockStorage = mock(CategoryStorage.class);
        underTest = new CategoriesController(mockStorage, movieStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        testCategory = new Category("Comedy", "testUrl");
    }

    @Test
    public void shouldFindCategoriesEndPoint() throws Exception {
        when(mockStorage.findAllCategories()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnViewWithOneGenre(){
        Category testCategory = new Category("Thriller", "testurl");
        when(mockStorage.findCategoryByGenre("Thriller")).thenReturn(testCategory);
        underTest.displaySingleCategory("Thriller", mockModel);
        verify(mockStorage).findCategoryByGenre("Thriller");
        verify(mockModel).addAttribute("categories", testCategory);
    }

    @Test
    public void addMovieShouldRedirectToCategoriesGenreEndpoint(){
        String result = underTest.addMovie("Out Cold", "Comedy", mockModel);
        when(mockStorage.findCategoryByGenre("Comedy")).thenReturn(testCategory);

        assertThat(result).isEqualTo("redirect:categories/Comedy");
    }

//    @Test
//    public void addMovieShouldStoreMovie(){
//        underTest.addMovie("Out Cold", "Comedy", mockModel);
//        Movie movieToStore = new Movie("Out Cold", testCategory);
//        verify(movieStorage).store(movieToStore);
//    }
}
