package org.wecancodeit.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    CategoryStorage categoryStorage;

    public Populator(CategoryStorage categoryStorage){
        this.categoryStorage = categoryStorage;
    }

    @Override
    public void run(String... args) throws Exception {
        Category drama = new Category("Drama");
        categoryStorage.store(drama);
        Category actionadventure = new Category("Action / Adventure");
        categoryStorage.store(actionadventure);
        Category comedy = new Category("Comedy");
        categoryStorage.store(comedy);
        Category romance = new Category("Romance");
        categoryStorage.store(romance);

    }
}
