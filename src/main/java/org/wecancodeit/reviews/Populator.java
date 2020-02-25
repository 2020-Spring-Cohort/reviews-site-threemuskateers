package org.wecancodeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Movie;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.CategoryStorage;
import org.wecancodeit.reviews.storage.MovieStorage;
import org.wecancodeit.reviews.storage.ReviewStorage;

@Component
public class Populator implements CommandLineRunner {

    private CategoryStorage categoryStorage;
    private MovieStorage movieStorage;
    private ReviewStorage reviewStorage;



    public Populator(CategoryStorage categoryStorage, MovieStorage movieStorage, ReviewStorage reviewStorage){
        this.categoryStorage = categoryStorage;
        this.movieStorage = movieStorage;
        this.reviewStorage = reviewStorage;
    }

    @Override
    public void run(String... args) throws Exception {
        Category drama = new Category("Drama", "drama");
        categoryStorage.store(drama);
        Category actionadventure = new Category("Action and Adventure", "action");
        categoryStorage.store(actionadventure);
        Category comedy = new Category("Comedy", "comedy");
        categoryStorage.store(comedy);
        Category thriller = new Category("Thriller", "thriller");
        categoryStorage.store(thriller);
        Category documentary = new Category("Documentary", "documentary");
        categoryStorage.store(documentary);
        Category other = new Category("Other", "other");
        categoryStorage.store(other);

        Movie irishmen = new Movie ("The Irishmen", drama);
        movieStorage.store(irishmen);
        Movie outCold = new Movie ("Out Cold", comedy);
        movieStorage.store(outCold);

        Review irishmenReview1 = new Review (irishmen, "Al", 3, "it was long");
        reviewStorage.store(irishmenReview1);

        Review outColdReview1 = new Review (outCold, "Nadir", 3, "it was fine");
        reviewStorage.store(outColdReview1);

    }
}
