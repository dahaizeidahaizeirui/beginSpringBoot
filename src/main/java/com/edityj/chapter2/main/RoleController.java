package com.edityj.chapter2.main;

import com.edityj.chapter2.EnumType.SexEnum;
import com.edityj.chapter2.pojo.Role;
import com.edityj.chapter2.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/mybatis")
public class RoleController {

    private RoleService roleService = null;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping("/getRole")
    @ResponseBody
    public Role getRole(Long id){
        System.out.println(roleService.getRole(id));
        return roleService.getRole(id);
    }

    @RequestMapping("/insertRole")
    @ResponseBody
    public Map<String, Object> insertRole(String username, String password, int sex, String name){
        Role role = new Role();
        role.setUsername(username);
        role.setPassword(password);
        role.setSex(SexEnum.getSexById(sex));
        role.setName(name);
        int update = roleService.insertRole(role);
        Map<String, Object> result = new HashMap<>();
        result.put("success", update == 1);
        result.put("role", role);
        return result;
    }
}
