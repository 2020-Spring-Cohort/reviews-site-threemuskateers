package org.wecancodeit.reviews;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Movie;
import org.wecancodeit.reviews.storage.repositories.CategoryRepository;
import org.wecancodeit.reviews.storage.repositories.MovieRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaWiringTest {
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private MovieRepository movieRepo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void categoryShouldHaveAListOfMovies() {
        Category testCategory = new Category("comedy","comedy");
        Movie testMovie = new Movie("Out Cold", testCategory);

        categoryRepo.save(testCategory);
        movieRepo.save(testMovie);

        entityManager.flush();
        entityManager.clear();

        Optional<Category> retrievedCategoryOptional = categoryRepo
                .findByGenre(testCategory.getGenre());

        Category retrievedCategory = retrievedCategoryOptional.get();
        Movie retrievedMovie = movieRepo.findById(testMovie.getId()).get();

        assertThat(retrievedCategory.getMovies()).contains(testMovie);

    }



}
