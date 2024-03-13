package com.dib.controller;


import com.dib.model.Employee;
import com.dib.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> DeleteEmployeeById(@PathVariable int id) {
        String message;
        try {
            employeeService.deleteEmployeeById(id);
            message = "Employee with ID " + id + " deleted successfully.";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Failed to delete employee with ID " + id + ": " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
        }
    }

}
