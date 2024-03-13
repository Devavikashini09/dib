package com.dib.service;

import com.dib.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public Employee createEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public Optional<Employee> getEmployeeById(int id);

    public Employee updateEmployeeById(int id, Employee employee);

    public void deleteEmployeeById(int id);

}