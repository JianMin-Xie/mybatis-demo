package com.xjm.dao;

import com.xjm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
   //查询全部用户
   List<User> selectUser();

   //根据id查询用户
   User selectUserById(int id);

   //通过密码和名字查询用户
   User selectUserByNP(@Param("username") String username, @Param("pwd") String pwd);

   User selectUserByNP2(Map<String,Object> map);

   //添加一个用户
   int addUser(User user);

   //根据id删除用户
   int deleteUser(int id);

   //修改一个用户
   int updateUser(User user);

   //模糊查询
   List<User> selectLike(String value);

   //模糊查询 #{} 不会引起sql注入
   List<User> selectLike2(String value);
   //模糊查询 ${} 会引起sql注入
   List<User> selectLike3(String value);
}