package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MapCategoryStorageTest {

    @Test
    public void shouldBeAbleToStoreCategoryInTheMap(){
        Category testCategory = new Category("horror", "test");
        CategoryStorage underTest = new MapCategoryStorage();
        underTest.store(testCategory);
        assertThat(underTest.findAllCategories()).contains(testCategory);

    }
}
