package com.xjm.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xjm.pojo.User;
import com.xjm.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Panda
 * @create 2021-03-05 20:06
 */
public class UserMapperTest {


    //分页查询 , 两个参数startIndex , pageSize
    @Test
    public void testSelectUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        int currentPage = 1;  //第几页
        int pageSize = 2;  //每页显示几个
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("startIndex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);

        List<User> users = mapper.selectUser(map);

        for (User user: users){
            System.out.println(user);
        }

        session.close();
    }

    @Test
    public void testUserByRowBounds() {
        SqlSession session = MybatisUtils.getSession();

        int currentPage = 2;  //第几页
        int pageSize = 2;  //每页显示几个
        RowBounds rowBounds = new RowBounds((currentPage-1)*pageSize,pageSize);

        //通过session.**方法进行传递rowBounds，[此种方式现在已经不推荐使用了]
        List<User> users = session.selectList("com.xjm.dao.UserMapper.getUserByRowBounds", null, rowBounds);

        for (User user: users){
            System.out.println(user);
        }
        session.close();
    }
    @Test
    public void testgetUserByPageHelper() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        PageHelper.startPage(0,2);
        List<User> userList = mapper.getUserByPageHelper();
        PageInfo pageInfo = new PageInfo(userList);

        System.out.println("userList:==>"+userList);
        System.out.println("pageInfo:==>"+pageInfo);
        session.close();
    }



}
