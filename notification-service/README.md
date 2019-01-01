# Project configuration

- Gradle Project
- Spring Boot: 2.1.1.RELEASE
- Group: br.com.racc.banking
- Artifact: notification-service
- Name: notification-service-app
- Description: Notification Service with RabbitMQ
- Package Name: br.com.racc.banking.notification
- Packaging: Jar 
- Java Version: 8
- Dependencies: DevTools, Lombok, Web, RabbitMQ, Config Client, Eureka Discovery, Actuator
- Path: http://localhost:8082/notifications


## RabbitMQ Docker container for queue

	docker run -d --name rabbitmq -p 15672:15672 -p 5672:5672 -e RABBITMQ_DEFAULT_USER=notification -e RABBITMQ_DEFAULT_PASS=notification rabbitmq:3.7.7-management
	
	Web console: http://localhost:15672

	
## Dependency

- configuration-service
- discovery-service
	
	
## References

- Spring AMQP: https://spring.io/projects/spring-amqp
- Messaging with RabbitMQ: https://spring.io/guides/gs/messaging-rabbitmq/
