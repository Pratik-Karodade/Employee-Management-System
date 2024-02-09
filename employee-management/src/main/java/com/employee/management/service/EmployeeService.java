package com.employee.management.service;

import com.employee.management.entity.Employee;
import com.employee.management.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }
}
