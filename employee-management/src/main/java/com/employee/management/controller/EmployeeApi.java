package com.employee.management.controller;

import com.employee.management.entity.Employee;
import com.employee.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/allEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employeeList = employeeService.getAllEmployee();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    // http://localhost:8080/getEmployeeById/{id}
    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
       return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    // http://localhost:8080/insertEmployee
    @PostMapping("/insertEmployee")
    public ResponseEntity<Employee> insertEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.insertEmployee(employee);
       return new ResponseEntity<>(employee1,HttpStatus.OK);
    }

    // http://localhost:8080/deleteEmployee/{id}
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Successfully deleted employee",HttpStatus.OK);
    }

    // http://localhost:8080/updateEmployee/{id}
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee employee1 = employeeService.updateEmployee(id,employee);
        return new ResponseEntity<>(employee1,HttpStatus.OK);
    }
}
