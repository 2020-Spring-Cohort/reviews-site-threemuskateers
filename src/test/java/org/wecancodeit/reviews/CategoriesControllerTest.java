package org.wecancodeit.reviews;

import org.wecancodeit.reviews.controllers.CategoriesController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


public class CategoriesControllerTest {

    private CategoriesController underTest;
    private CategoryStorage mockStorage;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockStorage = mock(CategoryStorage.class);
        underTest = new CategoriesController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }

    @Test
    public void shouldFindCategoriesEndPoint() throws Exception {
        when(mockStorage.findAllCategories()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
