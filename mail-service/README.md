# Project configuration

- Gradle Project
- Spring Boot: 2.1.1.RELEASE
- Group: br.com.racc.banking
- Artifact: mail-service
- Name: mail-service-app
- Description: Mail Service with RabbitMQ and GMail
- Package Name: br.com.racc.banking.mail
- Packaging: Jar 
- Java Version: 8
- Dependencies: DevTools, Lombok, Web, RabbitMQ, Mail, Config Client, Eureka Discovery, Actuator


## RabbitMQ Docker container for queue

	docker run -d --name rabbitmq -p 15672:15672 -p 5672:5672 -e RABBITMQ_DEFAULT_USER=notification -e RABBITMQ_DEFAULT_PASS=notification rabbitmq:3.7.7-management
	
	Web console: http://localhost:15672

	
## Dependency

- configuration-service
- discovery-service
- notification-service
