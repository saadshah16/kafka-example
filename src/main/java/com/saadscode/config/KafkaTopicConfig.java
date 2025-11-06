package com.saadscode.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
// This class will be responsible for creating topics
public class KafkaTopicConfig {

    @Bean
    public NewTopic saadscodeTopic() {
        return TopicBuilder.name("saadscode")
                .build();

    }
}
