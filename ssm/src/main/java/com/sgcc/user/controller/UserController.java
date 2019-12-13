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
     * ʹ��@AutowiredҲ���ԣ�@AutowiredĬ�ϰ�����װ��
     * @Resource Ĭ�ϰ�����װ�䣬���Ҳ���������ƥ���bean�Żᰴ����װ�䡣
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
     * ���Բ�ѯ
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
     * �����������
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/insertUser")
    public String testinsertUser() {
        User user = new User();
        user.setUserName("������");
        user.setPassword("3232322");
        user.setAge(22);
        int count = userService.insert(user);
        System.out.println("����" + count + "�����ݳɹ�");
        return "showUser";
    }
}