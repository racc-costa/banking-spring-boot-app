# Project configuration

- Gradle Project
- Spring Boot: 2.1.1.RELEASE
- Group: br.com.racc.banking
- Artifact: account-service
- Name: account-service-app
- Description: Account Service with Apache Cassandra
- Package Name: br.com.racc.banking.account
- Packaging: Jar
- Java Version: 8
- Dependencies: DevTools, Lombok, Web, Cassandra, Config Client, Eureka Discovery, Feign, Actuator
- Path: http://localhost:8084/accounts


## Cassandra Docker container for persistence

    docker run -d --name cassandra -p 9042:9042 cassandra:3.11.3
    
    
## Dependency

- configuration-service
- discovery-service
- client-service
- notification-service
	

## References

- Spring Data for Apache Cassandra: https://projects.spring.io/spring-data-cassandra/
- Spring Data for Apache Cassandra - Reference Documentation: https://docs.spring.io/spring-data/cassandra/docs/current/reference/html/
