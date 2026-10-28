# 🚀 API Gateway with Dynamic Routing

A Java Spring Boot project that implements a simple **Microservices Architecture** with dynamic API routing using a MySQL database.

## 📖 Project Overview

This project consists of three main components:

- **API Gateway:** Receives client requests and forwards them to the appropriate microservice.
- **User Service:** Handles user-related API requests.
- **Product Service:** Handles product-related API requests.

Instead of calling each microservice directly, clients send requests to the API Gateway. The Gateway retrieves the corresponding service URL from the MySQL `routes` table and forwards the request using `RestTemplate`.

## 🎯 Objectives

- Implement a basic microservices architecture using Spring Boot.
- Handle client requests through a single API Gateway.
- Implement dynamic routing using MySQL.
- Integrate backend services using REST APIs.
- Improve maintainability by storing routing configurations in a database.

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java 17 | Backend development |
| Spring Boot | Building backend applications |
| Spring Data JPA | Database interaction |
| RestTemplate | Forwarding HTTP requests |
| Maven | Dependency management and project build |
| MySQL | Storing routing configurations |
| XAMPP | Running the local MySQL server |
| REST API | Communication between services |
| HTML, CSS, JavaScript | Frontend development |

## 🏗️ Project Architecture

```text
                  Client
                    |
                    v
          API Gateway (Port 8080)
                    |
                    v
            MySQL: gateway_db
              Table: routes
                    |
             Dynamic Routing
               /         \
              v           v
       User Service   Product Service
         Port 8081      Port 8082
              |           |
              +-----+-----+
                    |
                    v
             Response to Client
```

## ⚙️ How It Works

1. The client sends an HTTP request to the API Gateway.
2. The Gateway reads the requested path.
3. It searches for the matching route in the MySQL database.
4. The Gateway retrieves the destination service URL.
5. `RestTemplate` forwards the request to the selected microservice.
6. The microservice processes the request and returns a response.
7. The Gateway returns that response to the client.

## ✨ Key Features

- Centralized API request handling.
- Database-driven dynamic routing.
- Separate User and Product services.
- REST API integration.
- MySQL database connectivity.
- Reduced dependency on hardcoded destination URLs.

## 📋 Prerequisites

Install the following software before running the project:

1. **Java JDK 17** or compatible Java 17 installation.
2. **Apache Maven** for building the applications.
3. **XAMPP** for running MySQL locally.
4. **Visual Studio Code** or another Java IDE.
5. **Postman** or a web browser for testing GET endpoints.

Verify the installations in your terminal:

```bash
java -version
mvn -version
```

The Java version should be 17. If your project includes the Maven Wrapper (`mvnw`), you can use it instead of installing Maven separately.

## 🗄️ Database Setup

### Step 1: Start MySQL

1. Open the XAMPP Control Panel.
2. Start the **MySQL** service.
3. Open phpMyAdmin at `http://localhost/phpmyadmin`.

### Step 2: Create the database

Run this SQL command in phpMyAdmin:

```sql
CREATE DATABASE gateway_db;
```

### Step 3: Create the routes table

Create the `routes` table using the column names and data types expected by your existing JPA entity and repository.

For example, the table can store:

| Route Path | Service URL |
|---|---|
| `/users` | `http://localhost:8081/users` |
| `/products` | `http://localhost:8082/products` |

**Important:** The example column names above describe the data. Use the exact column names required by your existing project code.

### Step 4: Configure the database connection

Open the relevant `application.properties` file for the Gateway and configure the database connection.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gateway_db
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Replace `YOUR_MYSQL_PASSWORD` with your actual MySQL password. If your local MySQL root account has no password, leave the password value empty.

Ensure the MySQL JDBC driver and JPA dependencies are included in the Gateway's `pom.xml`.

## 📥 Installation and Setup

### Step 1: Download or clone the project

If the project is hosted on GitHub:

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
cd YOUR_PROJECT_FOLDER
```

Replace the placeholders with your actual repository URL and project folder name.

Alternatively, open your existing project folder directly in VS Code.

### Step 2: Open the project

Open the root project folder in VS Code. Locate the folders containing:

- API Gateway
- User Service
- Product Service

The exact folder names depend on your project structure.

### Step 3: Build each service

Open a terminal inside each Spring Boot service folder and run:

```bash
mvn clean install
```

If you use the Maven Wrapper, run:

```bash
mvnw.cmd clean install
```

Resolve any dependency or compilation errors before starting the services.

## ▶️ How to Run the Project

Start the three applications separately. Keep each application running in its own terminal.

### Terminal 1: Start User Service

Open the User Service folder and execute:

```bash
mvn spring-boot:run
```

Verify that the service starts on port `8081`.

### Terminal 2: Start Product Service

Open the Product Service folder and execute:

```bash
mvn spring-boot:run
```

Verify that the service starts on port `8082`.

### Terminal 3: Start API Gateway

Open the API Gateway folder and execute:

```bash
mvn spring-boot:run
```

Verify that the Gateway starts on port `8080`.

**Note:** The actual port numbers must match each service's `application.properties` configuration. Start MySQL before testing database-dependent routing.

## 🌐 API Endpoints

### API Gateway Endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/gateway?path=/users` | Routes the request to User Service |
| GET | `/gateway?path=/products` | Routes the request to Product Service |

### Direct Microservice Endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `http://localhost:8081/users` | Access User Service directly |
| GET | `http://localhost:8082/products` | Access Product Service directly |

### Test the Gateway

Open a browser or Postman and send these GET requests:

**Get users**

```text
http://localhost:8080/gateway?path=/users
```

**Get products**

```text
http://localhost:8080/gateway?path=/products
```

If the services are running, the database contains the required routing entries, and the endpoint implementations are correct, the Gateway should return the corresponding microservice responses.

## 🗃️ Database Design

**Database:** `gateway_db`

**Table:** `routes`

The table stores routing configurations rather than user or product records.

| Field | Description |
|---|---|
| Route Path | Identifies the incoming request path |
| Service URL | Specifies the destination microservice URL |

Example routing configurations:

```text
/users    → http://localhost:8081/users
/products → http://localhost:8082/products
```

The User and Product services handle their own data independently of the routing table.

## 🧪 Testing Checklist

- [ ] MySQL starts successfully in XAMPP.
- [ ] The `gateway_db` database exists.
- [ ] Routing records are available in the database.
- [ ] User Service starts on the configured port.
- [ ] Product Service starts on the configured port.
- [ ] API Gateway starts on the configured port.
- [ ] Direct User Service endpoint returns a response.
- [ ] Direct Product Service endpoint returns a response.
- [ ] Gateway forwards requests to the correct service.
- [ ] An invalid or unknown route is handled appropriately.

## 🛠️ Troubleshooting

**1. MySQL connection error**

- Ensure MySQL is running in XAMPP.
- Verify the database name, username, password, and port.
- Confirm that the MySQL JDBC driver is included.

**2. Port already in use**

- Stop the application using the conflicting port, or configure a different port in `application.properties`.
- Update the routing URLs if a microservice's port changes.

**3. Maven build failure**

- Verify the Java and Maven versions.
- Check dependencies and Java compilation errors.
- Run `mvn clean install` from the correct service folder.

**4. Gateway returns an error**

- Verify that both microservices are running.
- Check that the requested route exists in MySQL.
- Verify the destination URL and the Gateway endpoint implementation.
- Inspect the application logs for connection or routing errors.

**5. Empty or incorrect API response**

- Test the microservice endpoint directly first.
- Confirm that the controller returns the expected response.
- Check the route configuration and HTTP method.

## 🔒 Future Improvements

- Add authentication and authorization.
- Implement request validation and centralized error handling.
- Add logging and monitoring.
- Introduce rate limiting.
- Support additional microservices.
- Improve routing configuration management.
- Add automated API tests.

These are potential future enhancements, not features claimed as already implemented.

## 👨‍💻 Author

**Nikhil Patil**

MCA Student | Java | Spring Boot | REST APIs | MySQL

---

*This project demonstrates the API Gateway pattern, database-driven routing, and communication between independent Spring Boot microservices.*
