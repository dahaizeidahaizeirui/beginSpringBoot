package com.edityj.chapter2.service;

import com.edityj.chapter2.mapper.RoleDao;
import com.edityj.chapter2.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao = null;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
    public Role getRole(Long id) {
        return roleDao.getRole(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
    public int insertRole(Role role) {
        return roleDao.insertRole(role);
    }
}
