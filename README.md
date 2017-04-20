# course-manager

Store information about online courses from different providers so I don't buy the same course twice.

Includes examples of:

1. Spring Rest Data providing HAL-JSON self-referential JSON, i.e the JSON contains a reference to the object it refers to. This has advantages for versioning and linking data. There is no need to define controllers and services, the endpoints are auto-discovered and made available based on the repositories defined. Note this prevents controller based paths from using the same path as the Rest data paths which by default are based on repository names, unless overridden with @RepositoryRestResource annotation.

2. RestController JSON API. This is a manually coded JSON response without the links of HAL. Using ../view/.. to avoid collision with REST Data urls.
 


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

1. View native JSON:  .../json/course/1
2. View HAL JSON:     .../api/
3. View form:         ../view/


##Usage

## Externalising Configuration

Spring has a sensible hierarchy for overriding property values. System and Environmental properties, being the furtherest removed from the code, override any property files; for example:
```
JAVA_OPTS=-Dserver.port=portnumber -Dspring.datasource.username=username -Dspring.datasource.password=password -Dspring.datasource.url=jdbc:oracle:thin:@hostname:portnumber:schemaname -Dspring.profiles.active=local -Dspring.jpa.hibernate.ddl-auto=validate 
```
(Replacing the placeholders with correct values relevant for each environment)


## Running Locally

### Viewing HAL+JSON in Browser

Using Firefox I needed to add JSONviewer add on and then set its preferences to include application/json in HTTP accept header and add hal+json as an alternate json content type. 

Optionally enable Firefoxes JSON viewer (gives 3 tabs including pretty print, raw data and headers).  Otherwise the browser tries to download a file.
