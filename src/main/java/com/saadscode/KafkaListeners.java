package com.saadscode;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "saadscode",
            groupId = "default"
    )
    void listener(String data) {
        System.out.println("Kafka Listener: " + data  + "🥳");
    }
}
