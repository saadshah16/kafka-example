package com.saadscode;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // It tells Spring this class handles web requests
@RequestMapping("api/v1/messages") // This sets the base URL for all endpoints in the class
public class MessageContoller {

    private KafkaTemplate<String, String> kafkaTemplate;

    // Constructor Injection - KafkaTemplate bean used to send messages
    public MessageContoller(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping // This makes a method to handle HTTP POST requests
    public ResponseEntity<String> publish(@RequestBody MessageRequest request) {
        // Core line - It tells Kafka to send request.message() to the topic "saadscode"
        kafkaTemplate.send("saadscode", request.message());
        return ResponseEntity.ok("Message sent successfully");
    }
}
