package com.edityj.chapter2.service;

import com.edityj.chapter2.mapper.RoleDao;
import com.edityj.chapter2.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao = null;

    @Override
    public Role getRole(Long id) {
        return roleDao.getRole(id);
    }
}
