package com.softuni.service;

import com.softuni.model.enitity.Role;
import com.softuni.model.enitity.RoleNameEnum;

public interface RoleService {
    void initRoles();

    Role findRole(RoleNameEnum roleNameEnum);
}
