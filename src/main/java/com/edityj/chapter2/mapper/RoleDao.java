package com.edityj.chapter2.mapper;

import com.edityj.chapter2.pojo.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {
    Role getRole(Long id);
}
