package com.employee.management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Employee {

    // http://localhost:8080/demo
    @GetMapping("/demo")
    public String demo(){
        return "Welcome to Employee Management System";
    }
}
