package com.xjm.dao;

import com.xjm.pojo.User;
import com.xjm.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author Panda
 * @create 2021-03-05 20:06
 */
public class UserMapperTest {

    @Test
    public void testGetAllUser() {
        SqlSession session = MybatisUtils.getSession();
        //本质上利用了jvm的动态代理机制
        UserMapper mapper = session.getMapper(UserMapper.class);

        List<User> users = mapper.getAllUser();
        for (User user : users){
            System.out.println(user);
        }

        session.close();
    }



}
