package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;


import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CategoryStorageCategoryImplTest {

    @Test
    public void shouldFindAllCategories(){
        CategoryRepository mockCatRepo = mock(CategoryRepository.class);
        Category catUnderTest = new Category("testGenre", "testUrl");
        CategoryStorage catStorageUnderTest = new CategoryStorageCategoryImpl(mockCatRepo);

        when(mockCatRepo.findAll()).thenReturn(Collections.singletonList(catUnderTest));
        catStorageUnderTest.store(catUnderTest);
        verify(mockCatRepo).save(catUnderTest);
        assertThat(catStorageUnderTest.findAllCategories()).contains(catUnderTest);

    }
}
