package org.wecancodeit.reviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
    @ManyToOne
    private Movie movie;
    private String author;
    @Id
    @GeneratedValue
    private Long reviewId;

    public Review(Movie movie, String author) {
        this.author = author;
        this.movie = movie;
    }

    }
