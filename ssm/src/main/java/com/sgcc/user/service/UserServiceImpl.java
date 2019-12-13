package com.sgcc.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgcc.user.dao.UserDao;
import com.sgcc.user.pojo.User;
@Transactional
@Service//("userService")
public class UserServiceImpl implements UserService {

    /**
     * ��Ϊû����spring���ļ�����ʽ������userServiceʵ���ֱ࣬��ͨ��getBean�õ� userService ���Ҳ���
     *  ��Ҫ��ʽ���� @Service ("userService")��ָ��bean������
     *  �൱��<bean id="userService" class="com.jxust.ssm.service.impl.UserServiceImpl"></bean>
     */
    @Resource
    private UserDao userDao;

    public User getUserById(Integer userid) {   
        return this.userDao.selectByPrimaryKey(userid);
    }

    @Override
    public int insert(User user) {
        return this.userDao.insert(user);
    }

}