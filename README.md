# Get Course Pricing - Springboot- Assignment

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [My SQL 8.0.19](https://www.mysql.com/)
## Database setup
- Create schema with name 'course-management' at mysql server
- modify 'application.properties' (file path : `src/main/resources/application.properties` ) with database credentials i.e username and password
## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.assignment.api.ApiApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
####  Curl
######  Syntex
```shell
curl http://localhost:8080/api/course/price/<courseId>/<countryCode>
```
######  Example
```shell
curl http://localhost:8080/api/course/price/3/US
```
####  Assumptions
- A course can map in country only once with single strategy, same mentioned at class `com.assignment.api.model.CoursePaymentDetail`
- Single query is enough to show price details differently at different pages
####  Datastore and schema
- Relational data store has been used, because schema is predictable so can be managed by normalization. In future for scaling purpose can be move on oracle or sql sever easily.

####  Covered more
- Unit test cases written
- Spring JPA used, so avoided queries complexity
- Discount facility also covered, can add discount as payment component. Its totally flexible.
- One demo.html added for demo. Up application and open this file in chrome for demo

####  UseCases to test

###### Courses
 | ID  | name |
| ------------- | ------------- |
| 1  | Machine learning  |
| 2  | Data Science  |
| 3  | IOT  |

###### Country
 | code  | name |currency|
| ------------- | ------------- |------------- |
| IND  |India  |INR|
| US  | United States  |USD|

##### List of possible URLs with success case and with different payment strategy and content
- http://localhost:8080/api/course/price/1/IND
- http://localhost:8080/api/course/price/2/IND
- http://localhost:8080/api/course/price/1/US
- http://localhost:8080/api/course/price/2/US
- http://localhost:8080/api/course/price/3/US

