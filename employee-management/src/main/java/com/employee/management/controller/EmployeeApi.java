package com.employee.management.controller;

import com.employee.management.entity.Employee;
import com.employee.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeApi {

    @Autowired
    EmployeeService employeeService;

    // http://localhost:8080/demo
    @GetMapping("/demo")
    public String demo(){
        return "Welcome to Employee Management System";
    }

    // http://localhost:8080/allStudents
    @GetMapping("/allStudents")
    public ResponseEntity<List<Employee>> getAllStudents(){
        List<Employee> employeeList = employeeService.getAllEmployee();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    // http://localhost:8080/getEmployeeById/{id}
    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
       return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

}
