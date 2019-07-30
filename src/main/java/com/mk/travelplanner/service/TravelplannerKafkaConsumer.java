package com.mk.travelplanner.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TravelplannerKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(TravelplannerKafkaConsumer.class);
    private static final String TOPIC = "topic_travelplanner";

    @KafkaListener(topics = "topic_travelplanner", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
