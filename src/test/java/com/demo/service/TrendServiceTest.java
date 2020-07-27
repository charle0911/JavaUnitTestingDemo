package com.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.SpringBootForumApplication;
import com.demo.entity.Topic;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest(classes = SpringBootForumApplication.class)
public class TrendServiceTest {

    @InjectMocks
    TrendService trendService;

    @Mock
    TopicService topicService;

//    @Spy
//    TopicService topicService;

    @Test
    public void setTopicService() {
        doReturn(new ArrayList<Topic>()).when(topicService).getAll();

        List<Topic> topics = trendService.getTopTopic(5);


        assertEquals(0, topics.size());
        verify(topicService, times(1)).getAll();
    }

    @Test
    public void checkGreaterTest() {

    }

    @Test
    public void getTopTopic() {
    }
}