# Project configuration

- Gradle Project
- Spring Boot: 2.1.1.RELEASE
- Group: br.com.racc.banking
- Artifact: client-service
- Name: client-service-app
- Description: Client Service with PostgreSQL
- Package Name: br.com.racc.banking.client
- Packaging: Jar 
- Java Version: 8
- Dependencies: DevTools, Lombok, Web, JPA, PostgreSQL, Config Client, Eureka Discovery, Feign, Actuator
- Path: http://localhost:8081/clients


## PostgreSQL Docker container for persistence

	docker run -d --name postgresql -p 5432:5432 -e POSTGRES_DB=db -e POSTGRES_USER=client -e POSTGRES_PASSWORD=client postgres:10.4

	
## Dependency

- configuration-service
- discovery-service
- notification-service
	

## References

- Spring Data: http://projects.spring.io/spring-data/
- Spring Data JPA - Reference Documentation: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
