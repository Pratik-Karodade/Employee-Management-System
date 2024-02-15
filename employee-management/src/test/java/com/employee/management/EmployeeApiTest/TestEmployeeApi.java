package com.employee.management.EmployeeApiTest;

import com.employee.management.controller.EmployeeApi;
import com.employee.management.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestEmployeeApi {

    @Autowired
    EmployeeApi employeeApi;

    @Test
    void testDemo(){
        String demoOutput = employeeApi.demo();
        Assertions.assertEquals("Welcome to Employee Management System", demoOutput);
    }

}
