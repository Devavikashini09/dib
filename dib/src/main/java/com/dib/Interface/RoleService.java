package com.dib.Interface;

import com.dib.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    public Role createRole(Role role);
    public List<Role> getAllRoles();
    public Optional<Role> getRoleById(int id);
    public Role updateRoleById(int id,Role role);
    public void deleteRoleById(int id);
}
