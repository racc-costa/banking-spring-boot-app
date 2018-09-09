# Project configuration

- Gradle Project
- Srping Boot: 2.0.4
- Group: br.com.racc.banking
- Artifact: discovery-service
- Name: discovery-service-app
- Description: Discovery Service with Eureka
- Package Name: br.com.racc.banking.discovery
- Packaging: Jar 
- Java Version: 8
- Dependencies: DevTools, Lombok, Web, RabbitMQ, Config Client, Actuator
- Path: http://localhost:8082/notifications


## RabbitMQ Docker container for queue

	docker run -d --name rabbitmq -p 15672:15672 -p 5672:5672 -e RABBITMQ_DEFAULT_USER=notification -e RABBITMQ_DEFAULT_PASS=notification rabbitmq:3.7.7-management
	
	Web console: http://localhost:15672

	
## Dependency

- configuration-service
	
	
## References

- Spring AMQP: https://spring.io/projects/spring-amqp
- Messaging with RabbitMQ: https://spring.io/guides/gs/messaging-rabbitmq/
