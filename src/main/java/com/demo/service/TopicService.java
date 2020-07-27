package com.demo.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Topic;
import com.demo.repository.TopicRepository;

@Service
public class TopicService {

    TopicRepository topicRepository;

    @Autowired
    public void setTopicRepository(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> getAll() {
        return topicRepository.findAll();
    }

    public List<Topic> getGreaterDate(Date date) {
        return Arrays.asList(new Topic(), new Topic(), new Topic());
    }

}
