# The Quote Service

## Rest API Application

### Trial Task for Kameleoon (OOO Камелеон)
### Technology Stack:
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Web MVC
- H2 Embedded DB
- Docker

* DB backup: QuoteDBbackup.zip in the root of project

### Technical Task

You should implement a REST API for the web interface in the two wireframes below.

Quote List Quote Detail

### Project requirements:

- source code should be published on https://github.com/;
- Docker image should be published on https://hub.docker.com/;
- project should have docker-compose.yaml for local deploy, OR you can deploy it on a public hosting provider (Heroku, etc);
- use any in-memory database (Derby, H2, SQLite);
- use Java and Spring Boot.
- The API should allow:

- creation of a user account (deletion and other CRUD operations not requested). User properties are name, email, password and date of creation;
- addition, viewing (including a method to get a random quote), modification, and deletion of quotes (real deletion from the database, not just via an archive flag). Quote properties include content, date of creation / update, link to user who posted it, link to votes;
- voting on quotes (either upvote or downvote);
- view of the top and worse 10 quotes, the details of each quote, and ideally a graph of the evolution of the votes over time.

Not requested: frontend part, authentication mechanism, and account rights management.
