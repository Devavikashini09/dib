package com.dib.controller;

import com.dib.model.Permission;
import com.dib.service.PermissionService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
    @Autowired
    public PermissionService permissionService;
    @PostMapping
    public ResponseEntity<Permission> savePermission(@RequestBody @NonNull Permission permission)
    {
        return new ResponseEntity<>(permissionService.savaPermission(permission), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Permission> getAllPermissions(){
        return permissionService.getAllPermissions();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Permission> getPermissionById(@PathVariable int id){
        Optional<Permission> permission=permissionService.getPermissionById(id);
        return permission.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Permission> updatePermissionById(@PathVariable int id,@RequestBody Permission permission){
        return new ResponseEntity<>(permissionService.updatePermissionById(id,permission),HttpStatus.CREATED);

    }
}
