# Project configuration

- Gradle Project
- Srping Boot: 2.0.4
- Group: br.com.racc.banking
- Artifact: configuration-service
- Name: configuration-service-app
- Description: Configuration Service
- Package Name: br.com.racc.banking.configuration
- Packaging: Jar
- Java Version: 8
- Dependencies: DevTools, Lombok, Config Server, Actuator


## Local git repo for configuration persistence

    $ cd $HOME
    $ mkdir config-repo
    $ cd config-repo
    $ git init .
    $ cp ../account-service-development.properties $HOME/config-repo/account-service-development.properties
    $ cp ../client-service-development.properties $HOME/config-repo/client-service-development.properties
    $ cp ../mail-service-development.properties $HOME/config-repo/mail-service-development.properties
    $ cp ../configuration-service-development.properties $HOME/config-repo/configuration-service-development.properties
    $ git add -A .
    $ git commit -m "Add properties"

# References

- Sring Cloud Config: https://cloud.spring.io/spring-cloud-config/
- Centralized Configuration: https://spring.io/guides/gs/centralized-configuration/
- Config Server Sample: https://github.com/spring-cloud-samples/configserver
