package com.college.gateway.service;

import com.college.gateway.model.Route;
import com.college.gateway.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// This class contains the main logic of the API Gateway:
// 1. Look up the route in the database
// 2. Forward the request to the correct microservice
// 3. Return the response back to the caller
@Service
public class RoutingService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private RestTemplate restTemplate;

    public String routeRequest(String path) {

        // Step 1: Find the matching route from the "routes" table in MySQL
        Route route = routeRepository.findByRoutePath(path);

        // Step 2: If no matching route is found, send an error message
        if (route == null) {
            return "{\"error\": \"No route configured for path: " + path + "\"}";
        }

        // Step 3: Build the complete URL of the target microservice
        // Example: http://localhost:8081 + /users
        String finalUrl = route.getServiceUrl() + path;

        System.out.println("Forwarding request to: " + finalUrl);

        // Step 4: Call the target microservice and return its response
        String response = restTemplate.getForObject(finalUrl, String.class);

        return response;
    }
}
