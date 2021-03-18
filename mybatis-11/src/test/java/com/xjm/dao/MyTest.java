package com.xjm.dao;

import com.xjm.mapper.UserMapper;
import com.xjm.pojo.User;
import com.xjm.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author Panda
 * @create 2021-03-11 23:03
 */
public class MyTest {

    /**
     * 一级缓存，结果分析：
     *      1. SQL语句只查询了一次
     *      2. 用的是同一个对象
     */
    @Test
    public void test(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);
        User user2 = mapper.queryUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);

        session.close();
    }

    // 一级缓存失效的四种情况：
    //1、sqlSession不同
    @Test
    public void testQueryUserById(){
        SqlSession session = MybatisUtils.getSession();
        SqlSession session2 = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserMapper mapper2 = session2.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);
        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);

        session.close();
        session2.close();
    }

    //2、sqlSession相同，查询条件不同
    @Test
    public void testQueryUserById2(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserMapper mapper2 = session.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);
        User user2 = mapper2.queryUserById(2);
        System.out.println(user2);
        System.out.println(user==user2);

        session.close();
    }

    //3、sqlSession相同，两次查询之间执行了增删改操作！
    @Test
    public void testQueryUserById3(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        HashMap map = new HashMap();
        map.put("name","kuangshen");
        map.put("id",4);
        mapper.updateUser(map);

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user==user2);

        session.close();
    }

    //4、sqlSession相同，手动清除一级缓存
    @Test
    public void testQueryUserById4(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        session.clearCache();//手动清除缓存

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user==user2);

        session.close();
    }

    /**
     * 二级缓存：
     * 1、只要开启了二级缓存，我们在同一个Mapper中的查询，可以在二级缓存中拿到数据
     * 2、查出的数据都会被默认先放在一级缓存中
     * 3、只有会话提交或者关闭以后，一级缓存中的数据才会转到二级缓存中
     *
     */
    @Test
    public void testQueryUserById5(){
        SqlSession session = MybatisUtils.getSession();
        SqlSession session2 = MybatisUtils.getSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        UserMapper mapper2 = session2.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);
        session.close();

        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);

        session2.close();
    }
}
