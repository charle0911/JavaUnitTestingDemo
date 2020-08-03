package com.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.demo.SpringBootForumTestApplication;
import com.demo.entity.Topic;
import com.demo.repository.TopicRepository;
import com.demo.service.TopicService;
import com.demo.service.TrendService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootForumTestApplication.class)
public class TopicControllerTest {

    private static final Integer DEFAULT_TOPIC_ID = 1;
    private static final Integer UPDATED_TOPIC_ID = 2;

    private static final String DEFAULT_TYPE = "news";
    private static final String UPDATED_TYPE = "exercise";

    private static final String DEFAULT_TOPIC = "New Topic";
    private static final String UPDATED_TOPIC = "Update Topic";

    private static final int DEFAULT_CLICK = 1;
    private static final int UPDATED_CLICK = 1;

    private static final Date DEFAULT_UPDATE_DATETIME = new Date();

    @Autowired
    private TopicService topicService;

    @Autowired
    private TrendService trendService;

    @Autowired
    private TopicRepository topicRepository;

    private TopicController topicController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        final TopicController topicController = new TopicController(topicService, trendService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(topicController).build();
    }

    @Test
    @Transactional
    public void createTopic() throws Exception {
        int databaseSizeBeforeCreate = topicRepository.findAll().size();

        Topic topic = createData();
        mockMvc.perform(post("/api/topic")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(topic)))
                .andExpect(status().isCreated())
                .andDo(print());

        List<Topic> topics = topicRepository.findAll();
        Topic result = topics.get(topics.size() - 1);
        assertThat(topics).hasSize(databaseSizeBeforeCreate + 1);
        assertThat(result.getClick()).isEqualTo(DEFAULT_CLICK);
        assertThat(result.getTopic()).isEqualTo(DEFAULT_TOPIC);
        assertThat(result.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(result.getUpdateDate()).isEqualTo(DEFAULT_UPDATE_DATETIME);
    }

    private Topic createData() {
        return new Topic()
                .setClick(DEFAULT_CLICK)
                .setType(DEFAULT_TYPE)
                .setTopic(DEFAULT_TOPIC)
                .setUpdateDate(DEFAULT_UPDATE_DATETIME);
    }
}