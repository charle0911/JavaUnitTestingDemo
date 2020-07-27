package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
