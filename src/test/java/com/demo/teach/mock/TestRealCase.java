package com.demo.teach.mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class TestRealCase {

    private TopicManager topicManager = new TopicManager();


    @Test
    public void testGetAllTopicReturnThreeTopic() {
        // Arrange
        String result = "Hot topic";
        TopicDAO mockDAO = Mockito.mock(TopicDAO.class);
        topicManager.setTopicDAO(mockDAO);

        Mockito.when(mockDAO.getTrendTopic(Mockito.any(Date.class))).thenReturn("Hot topic");

        // Act
        String trendTopic = topicManager.getTrendTopic(new Date());

        // Assert
        Mockito.verify(mockDAO, Mockito.times(1)).getTrendTopic(Mockito.any(Date.class));
        Assert.assertEquals(result, trendTopic);
    }

    class TopicManager {
        private TopicDAO topicDAO;

        public void setTopicDAO(TopicDAO topicDAO) {
            this.topicDAO = topicDAO;
        }

        public String getTrendTopic(Date date) {
            return topicDAO.getTrendTopic(date);
        }

    }

    class TopicDAO {

        public String getTrendTopic(Date date) {
            //Get data from db

            return "Topic Two";
        }
    }
}
