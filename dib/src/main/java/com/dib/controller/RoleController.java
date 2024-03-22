package com.dib.controller;

import com.dib.Interface.EmployeeService;
import com.dib.model.Role;
import com.dib.Interface.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
@CrossOrigin
public class RoleController {
    @Autowired
    public RoleService roleService;
    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable int id){
        Optional<Role> role=roleService.getRoleById(id);
        return role.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRoleById(@PathVariable int id,@RequestBody Role role){
        return new ResponseEntity<>(roleService.updateRoleById(id,role),HttpStatus.CREATED);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoleById(@PathVariable int id){

        String message;
        try {
            roleService.deleteRoleById(id);
            message = "Role with ID " + id + " deleted successfully.";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Role to delete employee with ID " + id + ": " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
        }

    }
}
