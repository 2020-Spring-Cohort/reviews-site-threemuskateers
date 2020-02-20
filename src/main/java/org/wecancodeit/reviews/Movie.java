package org.wecancodeit.reviews;

public class Movie {

    public String title;
    public long id;
    public String genre;

    public Movie(String title, String genre, long id) {
        this.title = title;
        this.id = id;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
}
