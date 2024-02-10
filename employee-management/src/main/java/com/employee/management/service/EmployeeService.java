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

    public Employee getEmployeeById(Long id){
        return employeeRepo.findById(id).orElse(null);
    }

    public Employee insertEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }

    public Employee updateEmployee(Long id, Employee newEmployee) {
        Employee employee = employeeRepo.findById(id).orElse(null);
        if (employee != null) {
            setNewEmployee(employee,newEmployee);
            return employeeRepo.save(employee);
        } else {
            return null;
        }
    }

    private void setNewEmployee(Employee employee,Employee newEmployee){
        employee.setFirstName(newEmployee.getFirstName());
        employee.setLastName(newEmployee.getLastName());
        employee.setMobileNum(newEmployee.getMobileNum());
    }
}
