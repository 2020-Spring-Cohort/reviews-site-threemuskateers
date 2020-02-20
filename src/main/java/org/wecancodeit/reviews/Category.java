package org.wecancodeit.reviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "genre")
    private Collection<Movie> movies;

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

    public Collection<Movie> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                '}';
    }
}
