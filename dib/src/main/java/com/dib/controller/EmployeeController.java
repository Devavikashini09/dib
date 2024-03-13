package com.dib.controller;

import com.dib.model.Branch;
import com.dib.model.Employee;
import com.dib.service.EmployeeService;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        Optional<Employee> employee=employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable int id,@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.updateEmployeeById(id,employee));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> DeleteEmployeeById(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();

    }
}
