package org.wecancodeit.reviews;

public class Category {


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
