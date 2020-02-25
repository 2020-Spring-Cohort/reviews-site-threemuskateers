package org.wecancodeit.reviews;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;


@Entity
public class Movie {

    @OneToMany (mappedBy = "movie")
    public Collection<Review> reviews;

    @Id
    @GeneratedValue
    public Long id;

    @ManyToOne
    private Category genre;

    public String title;

    public Movie(){}

    public Movie(String title, Category genre) {
        this.title = title;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Category getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", genre=" + genre +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (!id.equals(movie.id)) return false;
        if (genre != null ? !genre.equals(movie.genre) : movie.genre != null) return false;
        return title != null ? title.equals(movie.title) : movie.title == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
