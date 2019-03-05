package com.edityj.chapter2.main;

import com.edityj.chapter2.pojo.Role;
import com.edityj.chapter2.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mybatis")
public class RoleController {

    @Autowired
    private RoleService roleService = null;

    @RequestMapping("/getRole")
    @ResponseBody
    public Role getRole(Long id){
        System.out.println(roleService.getRole(id));
        return roleService.getRole(id);
    }
}
