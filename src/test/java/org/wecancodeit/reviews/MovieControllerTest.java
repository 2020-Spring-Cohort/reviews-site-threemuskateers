package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.controllers.CategoriesController;
import org.wecancodeit.reviews.controllers.MovieController;

import static org.mockito.Mockito.mock;

public class MovieControllerTest {
    private MovieController underTest;
    private Model model;
    private MovieStorage movieStorage;
    private Movie testMovie;

@Test
    public void shouldBeAbleToDisplayEndPointMovie(){
    Category testCategory = new Category("Comedy", "comedyImage");
    testMovie = new Movie("Out Cold", testCategory);
    movieStorage = mock(MovieStorage.class);
    underTest = new MovieController(movieStorage);

    String result = underTest.displayMovie();


}

}
