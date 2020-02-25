package org.wecancodeit.reviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

    public Review(){}

    public Movie getMovie() {
        return movie;
    }

    public String getAuthor() {
        return author;
    }

    public Long getReviewId() {
        return reviewId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (author != null ? !author.equals(review.author) : review.author != null) return false;
        return reviewId != null ? reviewId.equals(review.reviewId) : review.reviewId == null;
    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (reviewId != null ? reviewId.hashCode() : 0);
        return result;
    }
}
