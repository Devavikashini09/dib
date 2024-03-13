package com.dib.controller;

import com.dib.model.Role;
import com.dib.model.Transaction;
import com.dib.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
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
    public ResponseEntity<Void> deleteRoleById(@PathVariable int id){
       roleService.deleteRoleById(id);
        return ResponseEntity.noContent().build();
    }
}
