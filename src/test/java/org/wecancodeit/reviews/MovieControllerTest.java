package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.controllers.MovieController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class MovieControllerTest {
    private MovieController underTest;
    private Model model;
    private MovieStorage movieStorage;
    private Movie testMovie;

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
    public void shouldBeAbleToDisplayActualMovieID(){
        Category testCategory = new Category("Comedy", "comedyImage");
        testMovie = new Movie("Out Cold", testCategory);
        movieStorage = mock(MovieStorage.class);
        model = mock(Model.class);
        underTest = new MovieController(movieStorage);

        underTest.displayMovie(2L, model);
        verify(movieStorage).findMovieById(2L);
        verify(model).addAttribute("test movie", testMovie);



    }
}
