package com.dib.service;

import com.dib.Interface.EmployeeService;
import com.dib.exception.NotFoundUser;
import com.dib.model.Employee;
import com.dib.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    public EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployeeById(int id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        } else {
            throw new NotFoundUser();
        }
    }

    @Override
    public String deleteEmployeeById(int id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()) {
            Employee employee = optional.get();
            employeeRepository.save(employee);
            return "Employee deleted";
        } else {
            throw new NotFoundUser();
        }

    }
}