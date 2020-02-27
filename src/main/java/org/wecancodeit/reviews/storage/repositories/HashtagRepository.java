package org.wecancodeit.reviews.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.reviews.models.Hashtag;

import java.util.Collection;
import java.util.Optional;


public interface HashtagRepository extends CrudRepository<Hashtag, Long> {

    Optional<Hashtag> findHashtagByHashtag(String hashTag);

    @Override
    Iterable<Hashtag> findAll();


}
