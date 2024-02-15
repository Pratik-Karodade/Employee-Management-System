package com.employee.management.EmployeeApiTest;

import com.employee.management.controller.EmployeeApi;
import com.employee.management.entity.Employee;
import com.employee.management.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

@SpringBootTest
public class TestEmployeeApi {

    @Autowired
    EmployeeApi employeeApi;

    @MockBean
    EmployeeService employeeService;

    @Test
    void testDemo(){
        String demoOutput = employeeApi.demo();
        Assertions.assertEquals("Welcome to Employee Management System", demoOutput);
    }

    @Test
    void testGetAllEmployees(){
        List<Employee> employeeList = Collections
                .singletonList(new Employee(1L,"pratik1","karodade","860019321"));
        Mockito.when(employeeService.getAllEmployee()).thenReturn(employeeList);
        ResponseEntity<List<Employee>> responseEntity = employeeApi.getAllEmployees();
        Assertions.assertEquals("860019321",responseEntity.getBody().get(0).getMobileNum());
    }

}
