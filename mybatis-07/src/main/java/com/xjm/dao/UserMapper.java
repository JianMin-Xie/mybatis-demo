package com.xjm.dao;

import com.xjm.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

   //查询全部用户
   @Select("select * from user")
   public List<User> getAllUser();

   //根据id查询用户
   @Select("select * from user where id = #{id}")
   User selectUserById(@Param("id") int id);

   //添加一个用户
   @Insert("insert into user (id,name,pwd) values (#{id},#{name},#{pwd})")
   int addUser(User user);

   //修改一个用户
   @Update("update user set name=#{name},pwd=#{pwd} where id = #{id}")
   int updateUser(User user);

   //根据id删除用
   @Delete("delete from user where id = #{id}")
   int deleteUser(@Param("id")int id);
}