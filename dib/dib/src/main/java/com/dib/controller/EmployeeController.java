package com.dib.controller;

import com.dib.model.Employee;
import com.dib.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }
    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }

}
