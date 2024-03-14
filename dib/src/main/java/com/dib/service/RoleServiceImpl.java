package com.dib.service;

import com.dib.Interface.RoleService;
import com.dib.model.Role;
import com.dib.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    public   RoleRepository roleRepository;


    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getRoleById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role updateRoleById(int id, Role role) {
        if(roleRepository.existsById(id)){
            role.setId(id);
            return roleRepository.save(role);
        }
        else {
            throw new RuntimeException("Role doesn't exist with id"+ id);
        }
    }

    @Override
    public void deleteRoleById(int id) {
        roleRepository.deleteById(id);
    }
}
