package com.saadscode.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    // Variable that will hold the bootstrap server URL

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    // Configuration that we will pass to a consumer factory
    public Map<String, Object> consumerConfig() {
        Map<String, Object> props = new HashMap<>();
        // This tells the consumer where Kafka is running
        props.put("bootstrap.servers", bootstrapServers);
        // This tells Kafka how to convert from bytes into string
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return props;
    }

    @Bean
    public ConsumerFactory<String,String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }

    // Specifying the listener container factory
    // This listener receives all messages from all topics or partitions on a single thread
    @Bean
    public KafkaListenerContainerFactory<
            ConcurrentMessageListenerContainer<String,String>> factory(
            ConsumerFactory<String,String> consumerFactory
    ) {
        // Use the consumer factory we built earlier to make listeners that can receive messages from Kafka
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

}
