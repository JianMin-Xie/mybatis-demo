package com.xjm.dao;

import com.xjm.pojo.User;

import java.util.List;

public interface UserMapper {
   List<User> selectUser();
}