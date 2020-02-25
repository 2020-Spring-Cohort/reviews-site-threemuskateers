package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.controllers.MovieController;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Movie;
import org.wecancodeit.reviews.storage.MovieStorage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MovieControllerTest {
    private MovieController underTest;
    private Model model;
    private MovieStorage movieStorage;
    private Movie testMovie;
    private Category testCategory;


    @Test
    public void shouldBeAbleToDisplayEndPointMovie() {
        Category testCategory = new Category("Comedy", "comedyImage");
        testMovie = new Movie("Out Cold", testCategory);
        movieStorage = mock(MovieStorage.class);
        model = mock(Model.class);
        underTest = new MovieController(movieStorage);

        String result = underTest.displayMovie("Out Cold", model);
        when(movieStorage.findMovieById(1L)).thenReturn(testMovie);
        assertThat(result).isEqualTo("single_movie");

    }

    @Test
    public void movieShouldInteractWithDependenciesCorrectly(){
        testCategory = new Category("Comedy", "comedyImage");
        testMovie = new Movie("Out Cold", testCategory);
        movieStorage = mock(MovieStorage.class);
        model = mock(Model.class);
        underTest = new MovieController(movieStorage);

        when(movieStorage.findMovieByTitle("Out Cold")).thenReturn(testMovie);
        underTest.displayMovie("Out Cold", model);

        verify(movieStorage).findMovieByTitle("Out Cold");
        verify(model).addAttribute("movie", testMovie);

    }

    @Test
    public void movieControllerShouldDisplayTheCorrectView() throws Exception{
        testCategory = new Category("Comedy", "comedyImage");
        testMovie = new Movie("Out Cold", testCategory);
        movieStorage = mock(MovieStorage.class);
        model = mock(Model.class);
        underTest = new MovieController(movieStorage);

        when(movieStorage.findMovieByTitle("Out Cold")).thenReturn(testMovie);
        MockMvc mockMVC = MockMvcBuilders.standaloneSetup(underTest).build();

        mockMVC.perform(MockMvcRequestBuilders.get("/movies/Out Cold"))
                .andExpect(status().isOk())
                .andExpect(view().name("single_movie"))
                .andExpect(model().attributeExists("movie"))
                .andExpect(model().attribute("movie", testMovie));

    }
}
