package com.xjm.dao;

import com.xjm.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

   //查询全部用户
   @Select("select * from user")
   public List<User> getAllUser();
}