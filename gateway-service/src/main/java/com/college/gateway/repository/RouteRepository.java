package com.college.gateway.repository;

import com.college.gateway.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RouteRepository extends JpaRepository<Route, Integer> {

    
    Route findByRoutePath(String routePath);
}
