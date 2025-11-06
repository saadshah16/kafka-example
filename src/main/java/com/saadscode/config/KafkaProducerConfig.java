package com.saadscode.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    // Variable that will hold the bootstrap server URL

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    // Configuration that we will pass to a producer factory
    public Map<String, Object> producerConfig() {
        Map<String, Object> props = new HashMap<>();
        // This tells the producer where Kafka is running
        props.put("bootstrap.servers", bootstrapServers);
        // This tells Kafka how to convert your java objects into bytes before sending
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }

    // Producer factory that is responsible for creating producer instances
    @Bean
    public ProducerFactory<String,String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    // To send messages, we will use Kafka Template
    @Bean
    public KafkaTemplate<String,String> kafkaTemplate(
            ProducerFactory<String, String> producerFactory
    ) {
        return new KafkaTemplate<>(producerFactory);
    }
}
