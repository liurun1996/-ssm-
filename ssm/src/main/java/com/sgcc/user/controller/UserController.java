package com.sgcc.user.controller;
import javax.annotation.Resource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sgcc.user.pojo.User;
import com.sgcc.user.service.UserService;
@Controller
@RequestMapping("/test")
public class UserController {
    /**
     * 使用@Autowired也可以，@Autowired默认按类型装配
     * @Resource 默认按名称装配，当找不到与名称匹配的bean才会按类型装配。
     */
//    @Resource(name = "userService")
	@Autowired
    private UserService userService;
    @RequestMapping("/")
    public String index() {
    	return "showUser";
		
	}
    @Autowired
    BasicDataSource bd;
    
    /**
     * 测试查询
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/showUser")
    public String testtoshowUser(@RequestParam(value = "id") Integer id, Model model) {
       System.out.println(bd.getMinIdle());
    	System.out.println("id:" + id);
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "index";
    }

    /**
     * 测试添加数据
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/insertUser")
    public String testinsertUser() {
        User user = new User();
        user.setUserName("李清照");
        user.setPassword("3232322");
        user.setAge(22);
        int count = userService.insert(user);
        System.out.println("插入" + count + "条数据成功");
        return "showUser";
    }
}