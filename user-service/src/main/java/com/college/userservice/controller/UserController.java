package com.college.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class UserController {

    @GetMapping("/users")
    public List<Map<String, Object>> getUsers() {

        List<Map<String, Object>> userList = new ArrayList<>();

        Map<String, Object> user1 = new HashMap<>();
        user1.put("id", 1);
        user1.put("name", "Rahul Sharma");
        user1.put("email", "rahul@example.com");

        Map<String, Object> user2 = new HashMap<>();
        user2.put("id", 2);
        user2.put("name", "Priya Singh");
        user2.put("email", "priya@example.com");

        Map<String, Object> user3 = new HashMap<>();
        user3.put("id", 3);
        user3.put("name", "Amit Verma");
        user3.put("email", "amit@example.com");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        return userList;
    }
}
