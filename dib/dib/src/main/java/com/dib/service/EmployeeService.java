package com.dib.service;

import com.dib.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee createEmployee(Employee employee);
    public List<Employee> getAllEmployees();

}
