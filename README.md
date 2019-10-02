# openpayd case study

to compile
> mvn clean install

this will build application and run tests.

after that in a command line

> java -jar {application-jar}

this will run application at http://localhost:8080

application run with oauth2.0 authentication, therefore, in order to be able call requests, firstly use register and get token

in order to login


i have used hsqldb, so you dont need to set database configuration

## Postman collection api link

https://documenter.getpostman.com/view/56655/SVtPYrSL?version=latest

## Swagger UI Link

http://localhost:8080/swagger-ui.html


## Requirements
- java 1.8
- maven or junit to run tests
