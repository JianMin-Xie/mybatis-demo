package com.xjm.dao;

import com.xjm.pojo.User;

import java.util.List;

public interface UserMapper {

   //查询全部用户
   List<User> selectUser();
}