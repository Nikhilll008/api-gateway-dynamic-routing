
CREATE DATABASE IF NOT EXISTS gateway_db;

USE gateway_db;


CREATE TABLE IF NOT EXISTS routes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    route_path VARCHAR(100),
    service_url VARCHAR(255)
);


INSERT INTO routes (route_path, service_url) VALUES ('/users', 'http://localhost:8081');
INSERT INTO routes (route_path, service_url) VALUES ('/products', 'http://localhost:8082');


