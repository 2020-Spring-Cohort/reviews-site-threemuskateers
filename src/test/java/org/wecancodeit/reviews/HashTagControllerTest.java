package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wecancodeit.reviews.controllers.HashTagController;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.storage.repositories.HashtagRepository;
import org.wecancodeit.reviews.storage.repositories.ReviewRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class HashTagControllerTest {

    private HashtagRepository mockRepo;
    private ReviewRepository reviewRepo;
    private HashTagController underTest;
    private MockMvc mockMvc;


    @Test
    public void shouldShowAllHashtags() throws Exception{
        mockRepo = mock(HashtagRepository.class);
        underTest = new HashTagController(mockRepo, reviewRepo);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

        Hashtag test1 = new Hashtag("test1");
        mockRepo.save(test1);
        Hashtag test2 = new Hashtag("test2");
        mockRepo.save(test2);

        List<Hashtag> hashtagList = Collections.singletonList(test1);
        when(mockRepo.findAll()).thenReturn(hashtagList);

        mockMvc.perform(get("/hashtags"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("all-hashtags"))
                .andExpect(model().attributeExists("allHashtags"))
                .andExpect(model().attribute("allHashtags", hashtagList));


    }


}
