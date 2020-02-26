package org.wecancodeit.reviews.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private Long id;
    private String hashtag;
    @ManyToMany (mappedBy = "hashtags")
    private Collection<Review> reviews;

    public Hashtag(){}
    public Hashtag(String hashtag){
        reviews = new ArrayList<>();
        this.hashtag = hashtag;
    }

    public Long getId() {
        return id;
    }

    public String getHashtag() {
        return hashtag;
    }
}
