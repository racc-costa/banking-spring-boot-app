# Project configuration

- Gradle Project
- Spring Boot: 2.0.4
- Group: br.com.racc.banking
- Artifact: configuration-service
- Name: configuration-service-app
- Description: Configuration Service
- Package Name: br.com.racc.banking.configuration
- Packaging: Jar
- Java Version: 8
- Dependencies: DevTools, Lombok, Config Server, Eureka Discovery, Actuator


## Local git repo for configuration persistence

    $ cd $HOME
    $ mkdir config-repo
    $ cd config-repo
    $ git init .
    $ cp ../application.yml $HOME/config-repo/application.yml
    $ cp ../account-service-development.yml $HOME/config-repo/account-service-development.yml
    $ cp ../client-service-development.yml $HOME/config-repo/client-service-development.yml
    $ cp ../mail-service-development.yml $HOME/config-repo/mail-service-development.yml
    $ cp ../notification-service-development.yml $HOME/config-repo/notification-service-development.yml
    $ git add -A .
    $ git commit -m "Add properties"

# References

- Spring Cloud Config: https://cloud.spring.io/spring-cloud-config/
- Centralized Configuration: https://spring.io/guides/gs/centralized-configuration/
- Config Server Sample: https://github.com/spring-cloud-samples/configserver
