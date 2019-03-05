package com.edityj.chapter2.service;

import com.edityj.chapter2.pojo.Role;

public interface RoleService {
    Role getRole(Long id);
    int insertRole(Role role);
}
