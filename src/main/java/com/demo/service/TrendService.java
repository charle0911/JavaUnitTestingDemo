package com.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Topic;

import lombok.ToString;

@Service
public class TrendService {

    TopicService topicService;

    @Autowired
    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    public List<Topic> getTopTopic(int number) {
        return topicService.getAll().stream().sorted().limit(5).collect(Collectors.toList());
    }
}
