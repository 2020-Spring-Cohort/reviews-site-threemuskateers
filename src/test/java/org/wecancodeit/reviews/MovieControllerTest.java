package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.controllers.MovieController;

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

        String result = underTest.displayMovie(1L, model);
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

        when(movieStorage.findMovieById(1L)).thenReturn(testMovie);
        underTest.displayMovie(1L, model);

        verify(movieStorage).findMovieById(1L);
        verify(model).addAttribute("movie", testMovie);

    }

    @Test
    public void movieControllerShouldDisplayTheCorrectView() throws Exception{
        testCategory = new Category("Comedy", "comedyImage");
        testMovie = new Movie("Out Cold", testCategory);
        movieStorage = mock(MovieStorage.class);
        model = mock(Model.class);
        underTest = new MovieController(movieStorage);

        when(movieStorage.findMovieById(1L)).thenReturn(testMovie);
        MockMvc mockMVC = MockMvcBuilders.standaloneSetup(underTest).build();

        mockMVC.perform(MockMvcRequestBuilders.get("/categories/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("single_movie"))
                .andExpect(model().attributeExists("movie"))
                .andExpect(model().attribute("movie", testMovie));

    }
}
