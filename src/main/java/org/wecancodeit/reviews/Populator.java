package org.wecancodeit.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        Category actionadventure = new Category("Action / Adventure", "action");
        categoryStorage.store(actionadventure);
        Category comedy = new Category("Comedy", "comedy");
        categoryStorage.store(comedy);
        Category thriller = new Category("Thriller", "thriller");
        categoryStorage.store(thriller);

        Movie irishmen = new Movie ("The Irishmen", drama);
        movieStorage.store(irishmen);
        Movie outCold = new Movie ("Out Cold", comedy);
        movieStorage.store(outCold);

        Review irishmenReview1 = new Review (irishmen, "Al");
        reviewStorage.store(irishmenReview1);


    }
}
