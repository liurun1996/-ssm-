package com.sgcc.user.service;

import com.sgcc.user.pojo.User;

public interface UserService {
    //����id����
    public User getUserById(Integer userid);

    //���һ������
    public int insert(User user);
}