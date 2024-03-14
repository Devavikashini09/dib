package com.dib.Interface;

import com.dib.model.Permission;

import java.util.List;
import java.util.Optional;

public interface PermissionService {
    public Permission savaPermission(Permission permission);
    public List<Permission> getAllPermissions();
    public Optional<Permission> getPermissionById(int id);
    public Permission updatePermissionById(int id,Permission permission);
    public void deletePermissionById(int id);
}
