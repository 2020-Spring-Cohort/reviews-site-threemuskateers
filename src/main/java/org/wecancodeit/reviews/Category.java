package org.wecancodeit.reviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    public Category(){}

    public Category(String genre, String imgUrl) {
        this.genre = genre;
        this.imgUrl = imgUrl;
    }

    private String genre;

    public String imgUrl;

    public String getGenre() {
        return genre;
    }

}
