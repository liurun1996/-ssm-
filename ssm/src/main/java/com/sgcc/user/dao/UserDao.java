package com.sgcc.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sgcc.user.pojo.User;
@Mapper
public interface  UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}