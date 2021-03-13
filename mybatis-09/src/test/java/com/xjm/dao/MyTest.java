package com.xjm.dao;

import com.xjm.mapper.TeacherMapper;
import com.xjm.pojo.Teacher;
import com.xjm.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author Panda
 * @create 2021-03-11 23:03
 */
public class MyTest {

    @Test
    public void testGetTeacher(){
        SqlSession session = MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        System.out.println(teacher.getName());
        System.out.println(teacher.getStudents());
    }

    @Test
    public void testGetTeacher2(){
        SqlSession session = MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);
        System.out.println(teacher.getName());
        System.out.println(teacher.getStudents());
    }
}
