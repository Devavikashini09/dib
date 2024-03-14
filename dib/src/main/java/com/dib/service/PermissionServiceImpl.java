package com.dib.service;

import com.dib.Interface.PermissionService;
import com.dib.model.Permission;
import com.dib.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    public PermissionRepository permissionRepository;
    @Override
    public Permission savaPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public Optional<Permission> getPermissionById(int id) {
        return permissionRepository.findById(id);
    }
    @Override
    public Permission updatePermissionById(int id, Permission permission) {
        if(permissionRepository.existsById(id)){
           permission.setId(id);
            return permissionRepository.save(permission);
        }
        else{
            throw new RuntimeException("Permission not found with"+ id);
        }
    }

    @Override
    public void deletePermissionById(int id) {
        permissionRepository.deleteById(id);
    }
}
