package com.mk.travelplanner.web.rest;

import com.mk.travelplanner.service.TravelplannerKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/travelplanner-kafka")
public class TravelplannerKafkaResource {

    private final Logger log = LoggerFactory.getLogger(TravelplannerKafkaResource.class);

    private TravelplannerKafkaProducer kafkaProducer;

    public TravelplannerKafkaResource(TravelplannerKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
