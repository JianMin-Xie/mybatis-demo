package com.xjm.dao;

import com.xjm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

   //选择全部用户实现分页
   List<User> selectUser(Map<String,Integer> map);

   //选择全部用户RowBounds实现分页
   List<User> getUserByRowBounds();

   //选择全部用户pagehelper实现分页
   List<User> getUserByPageHelper();
}