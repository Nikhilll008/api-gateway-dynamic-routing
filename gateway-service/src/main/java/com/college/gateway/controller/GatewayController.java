package com.college.gateway.controller;

import com.college.gateway.service.RoutingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/gateway")
@CrossOrigin(origins = "*") 
public class GatewayController {

    @Autowired
    private RoutingService routingService;

    @GetMapping
    public String handleRequest(@RequestParam("path") String path) {
        return routingService.routeRequest(path);
    }
}
