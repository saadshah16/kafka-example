# Kafka Example — Spring Boot Producer & Consumer

A simple Spring Boot project demonstrating how to integrate **Apache Kafka** with a REST API.
It shows how to configure producers, consumers, and topics, publish messages through an endpoint, and consume them using a Kafka listener.

## Tech Stack

* Java 17+
* Spring Boot 3.x
* Spring Kafka
* Apache Kafka
* Maven

## Project Structure

```
src/main/java/com/saadscode
│
├── config/
│   ├── KafkaTopicConfig.java        # creates 'saadscode' topic
│   ├── KafkaProducerConfig.java     # producer setup (KafkaTemplate)
│   └── KafkaConsumerConfig.java     # consumer setup (listener factory)
│
├── KafkaApplication.java            # main Spring Boot entry point
├── MessageController.java           # REST API → publish to Kafka
├── MessageRequest.java              # model for request body
└── KafkaListeners.java              # listens and logs consumed messages
```

## How to Run

1. Start Kafka locally (via Kafka CLI or Docker).
2. Set the broker address in `application.properties`:

   ```
   spring.kafka.bootstrap-servers=localhost:9092
   ```
3. Run the app:

   ```
   mvn spring-boot:run
   ```

## Test the API

Send a POST request:

```
POST http://localhost:8080/api/v1/messages
Content-Type: application/json

{
  "message": "API with Kafka"
}
```

## Expected Output

Console will log:

```
Kafka Listener: API with Kafka
```

## Author

**Saad Shah**
🔗 [linkedin.com/in/saadshah16](https://linkedin.com/in/saadshah16)
