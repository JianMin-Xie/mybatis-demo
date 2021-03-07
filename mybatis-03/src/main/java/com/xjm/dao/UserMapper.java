package com.xjm.dao;

import com.xjm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

   //根据id查询用户
   User selectUserById(int id);
}