package com.xjm.mapper;

import com.xjm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author Panda
 * @create 2021-03-18 22:54
 */
public interface UserMapper {
    //根据id查询用户
    User queryUserById(@Param("id") int id);
    //修改用户
    int updateUser(Map map);
}
