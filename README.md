# API Gateway with Dynamic Routing

A mini MCA/BCA project built using Java Spring Boot, MySQL, HTML, CSS and JavaScript.

## Features
- API Gateway
- Dynamic Routing using MySQL
- User Service
- Product Service
- Simple Frontend Dashboard

## Tech Stack
- Java Spring Boot
- MySQL
- Maven
- HTML, CSS, JavaScript

## Architecture

Frontend → API Gateway → MySQL Routes → Microservices

## Services
- Gateway Service (8080)
- User Service (8081)
- Product Service (8082)

## Run Project

### User Service
```bash
cd user-service
mvn spring-boot:run
```

### Product Service
```bash
cd product-service
mvn spring-boot:run
```

### Gateway Service
```bash
cd gateway-service
mvn spring-boot:run
```

### Frontend
Open `frontend/index.html` using Live Server.

## Author
Nikhil Patil