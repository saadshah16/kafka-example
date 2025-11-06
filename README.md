📦 Kafka Example — Spring Boot Producer & Consumer

A simple Spring Boot project demonstrating how to integrate Apache Kafka with a REST API.
It shows how to:

Configure Kafka producers, consumers, and topics in Spring.

Publish messages via an HTTP endpoint.

Consume and log those messages using a Kafka listener.

🧠 What You’ll Learn

How Spring manages Kafka beans (KafkaTemplate, ConsumerFactory, etc.).

How to auto-create topics with NewTopic.

How to expose a REST API that produces messages to Kafka.

How to listen for and consume messages from a Kafka topic.

⚙️ Tech Stack

Java 17 +

Spring Boot 3.x

Spring Kafka

Apache Kafka 3.x

Maven

🏗️ Project Structure
src/main/java/com/saadscode
│
├── config/
│   ├── KafkaTopicConfig.java        # creates 'saadscode' topic
│   ├── KafkaProducerConfig.java     # producer setup (KafkaTemplate)
│   └── KafkaConsumerConfig.java     # consumer setup (listener factory)
│
├── KafkaApplication.java            # main Spring Boot entry point
├── MessageController.java           # REST API → publish to Kafka
├── MessageRequest.java              # simple record for incoming JSON
└── KafkaListeners.java              # @KafkaListener methods (consumer)

🚀 How to Run
1️⃣ Start Kafka Locally

Make sure a Kafka broker is running, e.g.:

zookeeper-server-start.sh config/zookeeper.properties
kafka-server-start.sh config/server.properties


(Or use Docker if preferred.)

2️⃣ Configure the broker address

In src/main/resources/application.properties:

spring.kafka.bootstrap-servers=localhost:9092

3️⃣ Build and Run
mvn spring-boot:run

📡 Test the Producer Endpoint

Send a POST request:

POST http://localhost:8080/api/v1/messages
Content-Type: application/json

{
  "message": "API with Kafka"
}


✅ You should see the message printed by your Kafka listener in the console.

📥 Expected Console Output
Kafka Listener: Hello Kafka!!
Kafka Listener: API with Kafka

🧩 Key Concepts Illustrated

@Configuration + @Bean → register Kafka factories as Spring beans.

KafkaTemplate → used to send messages.

@KafkaListener → automatically consumes messages from topics.

Dependency Injection → Spring injects KafkaTemplate into the controller.

🧑‍💻 Author

Saad Shah
📍 Syracuse University | M.S. Computer Science
🔗 linkedin.com/in/saadshah16
