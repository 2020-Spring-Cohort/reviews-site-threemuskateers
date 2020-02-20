package org.wecancodeit.reviews;

import org.springframework.ui.Model;
import org.wecancodeit.reviews.controllers.CategoriesController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


public class CategoriesControllerTest {

    private CategoriesController underTest;
    private CategoryStorage mockStorage;

    private MockMvc mockMvc;
    private Model mockModel;

    @BeforeEach
    public void setUp() {
        mockModel = mock(Model.class);
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

    @Test
    public void shouldReturnViewWithOneGenre(){
        Category testCategory = new Category("Thriller", "testurl");
        when(mockStorage.findCategoryByGenre("Thriller")).thenReturn(testCategory);
        underTest.displaySingleCategory("Thriller", mockModel);
        verify(mockStorage).findCategoryByGenre("Thriller");
        verify(mockModel).addAttribute("categories", testCategory);
    }


//    @Test
//    public void shouldGoToIndividualEndpoint() throws Exception{
//        Category testCategory = new Category("testgenre", "testurl");
//        when(mockStorage.findCategoryByGenre("testgenre")).thenReturn(testCategory);
//        mockMvc.perform(get("/catgories/testgenre"))
//                .andExpect(status().isOk())
//                .andExpect(view().name
//    }
}
