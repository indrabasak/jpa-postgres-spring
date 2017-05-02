[![Build Status][travis-badge]][travis-badge-url]

![](./img/postgres.png)

JPA PostgreSQL Spring Service Example
=========================================
This is a [**Spring Boot**](https://projects.spring.io/spring-boot/) based microservice example backed by
[**PostgreSQL**](https://www.postgresql.org/) database. This examples shows the following:
* Use `spring.datasource` properties and Spring Data auto configuration.
* How to use JPA's `CrudRepository`
* How to insert `UUID` field in Postgres database and generate `UUID `index.
* How to convert Java `Enum` to Postgres `Enum` type.
* How to use `Dozer` Java Bean mapper.

### PostgreSQL Assumptions
* You have a PostgreSQL database server running on your `localhost` and in port `5432`.
* You have a database named `postgres` running on the server
* The server has a user named `postgres` with password `postgres`.
* If any of the assumptions doesn't hold true, change the `spring.datasource` properties in the `application.yml` file.

### Create Database Entities
Execute the `create-db.sql` script under `resources` directory on your PostgreSQL server either using  PostgreSQL administration and management tools, [pgAdmin](https://www.pgadmin.org/), 
or from the PostgreSQL interactive terminal program, called `psql`.

### Build
Execute the following command from the parent directory:
```
mvn clean install
```

### Start the Service
The main entry point `jpa-postgres-spring` example is `com.basaki.example.postgres.boot.BookApplication` class.
You can start the application from an IDE by starting the `BookApplication` class.
```

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.4.1.RELEASE)
...
2017-03-08 21:50:17.987  INFO 62548 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2017-03-08 21:50:17.992  INFO 62548 --- [           main] c.b.e.p.spring.boot.BookApplication      : Started BookApplication in 7.152 seconds (JVM running for 7.566)

```
The application starts up at port `8080`.

### Accessing Swagger 
On your browser, navigate to `http://localhost:8080/` to view the Swagger. 
![](./img/book-swagger.png)

Click the `Show/Hide` link to view all the operations exposed by Book API.

#### POST Example
Once expanded, create a new Book entry by clicking `POST` and entering the following JSON snippet in the `request` field and click `Try it out!`. 
![](./img/book-post-req.png)

Here is the response you get back. Please notice the book title and the author gets captitalized before insertion.
![](./img/book-post-rsp.png)

#### GET Example
To view all books, click `GET` and entry either `title`, `author`, `genre` or any combination of them and click lick `Try it out!`. 
The `title` and `author` parameters are case insensitive. 
Here is the response you get back:
![](./img/book-get-rsp.png)

[travis-badge]: https://travis-ci.org/indrabasak/jpa-postgres-spring.svg?branch=master
[travis-badge-url]: https://travis-ci.org/indrabasak/jpa-postgres-spring/