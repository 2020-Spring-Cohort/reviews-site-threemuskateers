package org.wecancodeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Movie;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.CategoryStorage;
import org.wecancodeit.reviews.storage.MovieStorage;
import org.wecancodeit.reviews.storage.ReviewStorage;
import org.wecancodeit.reviews.storage.repositories.HashtagRepository;

@Component
public class Populator implements CommandLineRunner {

    private CategoryStorage categoryStorage;
    private MovieStorage movieStorage;
    private ReviewStorage reviewStorage;
    private HashtagRepository hashRepo;

    public Populator(CategoryStorage categoryStorage, MovieStorage movieStorage, ReviewStorage reviewStorage, HashtagRepository hashRepo){
        this.categoryStorage = categoryStorage;
        this.movieStorage = movieStorage;
        this.reviewStorage = reviewStorage;
        this.hashRepo = hashRepo;
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

        Movie irishmen = new Movie ("The Irishman", drama);
        movieStorage.store(irishmen);

        Movie movie2 = new Movie ("A Marriage Story", drama);
        movieStorage.store(movie2);

        Movie movie3 = new Movie ("Uncut Gems", drama);
        movieStorage.store(movie3);

        Movie outCold = new Movie ("Out Cold", comedy);
        movieStorage.store(outCold);

        Movie movie4 = new Movie ("Hot Rod", comedy);
        movieStorage.store(movie4);

        Movie movie5 = new Movie ("Jojo Rabbit", comedy);
        movieStorage.store(movie5);

        Movie movie6 = new Movie ("Bourne Identity", actionadventure);
        movieStorage.store(movie6);
        Movie movie7 = new Movie ("Sonic The Hedgehog", actionadventure);
        movieStorage.store(movie7);
        Movie movie8 = new Movie ("Mission Impossible", actionadventure);
        movieStorage.store(movie8);

        Movie movie9 = new Movie ("Saw", thriller);
        movieStorage.store(movie9);
        Movie movie10 = new Movie ("The Babadook", thriller);
        movieStorage.store(movie10);
        Movie movie11 = new Movie ("Hereditary", thriller);
        movieStorage.store(movie11);

        Movie movie12 = new Movie ("Blackfish", documentary);
        movieStorage.store(movie12);
        Movie movie13 = new Movie ("Jiro Dreams Of Sushi", documentary);
        movieStorage.store(movie13);
        Movie movie14 = new Movie ("Fyre", documentary);
        movieStorage.store(movie14);


        Movie movie15 = new Movie ("A Star Is Born", other);
        movieStorage.store(movie15);
        Movie movie16 = new Movie ("The Room", other);
        movieStorage.store(movie16);
        Movie movie17 = new Movie ("Face Off", other);
        movieStorage.store(movie17);





        Review irishmenReview1 = new Review (irishmen, "Al", 4,
                "Sed ut perspiciatis unde omnis iste natus error sit " +
                        "voluptatem accusantium doloremque laudantium, totam rem " +
                        "aperiam, eaque ipsa quae ab illo inventore veritatis et quasi " +
                        "m eum fugiat quo voluptas nulla pariatur?");
        reviewStorage.store(irishmenReview1);

        Hashtag hashtag2 = new Hashtag("boss");
        hashRepo.save(hashtag2);
        irishmenReview1.addHashtag(hashtag2);
//        reviewStorage.store(irishmenReview1);

        Hashtag hashtag3 = new Hashtag("boring");
        hashRepo.save(hashtag3);
        irishmenReview1.addHashtag(hashtag3);
//        reviewStorage.store(irishmenReview1);

        Hashtag hashtag7 = new Hashtag("oscars");
        hashRepo.save(hashtag7);
        irishmenReview1.addHashtag(hashtag7);
        reviewStorage.store(irishmenReview1);


        Review irishmenReview2 = new Review (irishmen, "Nadir", 3,
                "Nadir liked the movie even though he didn't see it either.  He actually" +
                        "thought it was called the Irishmen which basically explains alot.");
        reviewStorage.store(irishmenReview2);

        Review irishmenReview3 = new Review (irishmen, "Olivia", 3,
                "Even though I didn't see it.  I think it was probably a really good movie.");
        reviewStorage.store(irishmenReview3);



        Review outColdReview1 = new Review (outCold, "Nadir", 3, "it was fine");
        reviewStorage.store(outColdReview1);

        Review marriageStory1 = new Review (movie2, "Olivia",1,"I am not a " +
                "fan of some of the actors/actresses involved in this film.  I also did" +
                "not see it.  I also assume it was bad because it is about marriage.");

        reviewStorage.store(marriageStory1);

        marriageStory1.addHashtag(hashtag7);
//        reviewStorage.store(marriageStory1);


        marriageStory1.addHashtag(hashtag3);
        reviewStorage.store(marriageStory1);

    }
}
