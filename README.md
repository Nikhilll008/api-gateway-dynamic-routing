# 🚀 API Gateway with Dynamic Routing

## 📖 Project Overview

This project demonstrates a **Microservices Architecture** using **Spring Boot**. It contains an **API Gateway**, a **User Service**, and a **Product Service**. Instead of calling each microservice directly, the client sends all requests to the API Gateway. The Gateway checks the route in a MySQL database and forwards the request to the correct microservice.

---

## 🎯 Objective

- Implement Microservices using Spring Boot.
- Use a single API Gateway to handle all client requests.
- Perform Dynamic Routing using data stored in MySQL.
- Improve scalability and maintainability of the application.

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Maven
- MySQL (XAMPP)
- REST API
- HTML, CSS, JavaScript

---

## 🏗️ Project Architecture

```
Client
   │
   ▼
API Gateway (8080)
   │
   ▼
MySQL (Routes Table)
   │
   ├────────► User Service (8081)
   │
   └────────► Product Service (8082)
```

---

## ⚙️ How It Works

1. The client sends a request to the API Gateway.
2. The Gateway checks the requested path in the MySQL **routes** table.
3. It finds the corresponding microservice URL.
4. The Gateway forwards the request using **RestTemplate**.
5. The microservice processes the request and returns the response.
6. The Gateway sends the response back to the client.

---

## 🌐 API Endpoints

### Gateway

```
GET /gateway?path=/users
GET /gateway?path=/products
```

### User Service

```
GET /users
```

### Product Service

```
GET /products
```

---

## 🗄️ Database

Database Name:

```
gateway_db
```

Table:

```
routes
```

Example:

| Route Path | Service URL |
|------------|------------------------------|
| /users | http://localhost:8081/users |
| /products | http://localhost:8082/products |

The database stores only routing information, while the actual user and product data are handled by their respective microservices.

---

## ✨ Features

- API Gateway Pattern
- Dynamic Routing
- REST APIs
- Spring Boot Microservices
- MySQL Integration
- Centralized Request Handling

---

## 👨‍💻 Author

**Nikhil Patil**

MCA Student | Java | Spring Boot | REST API | MySQL
