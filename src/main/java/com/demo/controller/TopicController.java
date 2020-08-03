package com.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.entity.Topic;
import com.demo.service.TopicService;
import com.demo.service.TrendService;
import com.demo.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class TopicController {

    TopicService topicService;
    TrendService trendService;

    @Autowired
    TopicController(TopicService topicService, TrendService trendService) {
        this.topicService = topicService;
        this.trendService = trendService;
    }

    @GetMapping("/topic")
    public ResponseEntity<List<Topic>> getAllTopic() {
        return ResponseEntity.ok().body(topicService.getAll());
    }

    @GetMapping("/topic/{id}")
    public ResponseEntity<Topic> getTopic(@PathVariable long id) {
        Optional<Topic> topic = topicService.findById(id);
        return ResponseUtil.wrapOrNotFound(topic);
    }

    @PostMapping("/topic")
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) throws URISyntaxException {
        Topic result = topicService.add(topic);
        return ResponseEntity.created(new URI("/api/topic/" + result.getId())).body(result);
    }

}
