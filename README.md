# course-manager

Store information about online courses from different providers so I don't buy the same course twice.

Includes examples of:

1. Spring Rest Data providing HAL-JSON self-referential JSON, i.e the JSON contains a reference to the object it refers to. This has advantages for versioning and linking data.

2. RestController JSON API
 


## Technologies

- Java
- Maven
- Lombok
- Spring Data, JPA with hibernate provider
- Spring Data Rest
- JSON, Jackson
- H2
- Spring Boot, MVC

## URLS


##Usage

## Externalising Configuration

Spring has a sensible hierarchy for overriding property values. System and Environmental properties, being the furtherest removed from the code, override any property files; for example:
```
JAVA_OPTS=-Dserver.port=portnumber -Dspring.datasource.username=username -Dspring.datasource.password=password -Dspring.datasource.url=jdbc:oracle:thin:@hostname:portnumber:schemaname -Dspring.profiles.active=local -Dspring.jpa.hibernate.ddl-auto=validate 
```
(Replacing the placeholders with correct values relevant for each environment)


## Running Locally

