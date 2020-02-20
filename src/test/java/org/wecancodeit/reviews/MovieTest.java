package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    @Test
    public void moviePojoShouldHaveId(){
        Movie movie = new Movie("testTitle", "testGenre", 123);
        long result = movie.getId();
        assertEquals(123, result);
    }



}
