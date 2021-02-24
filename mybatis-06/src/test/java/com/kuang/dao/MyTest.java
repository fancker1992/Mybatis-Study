package com.kuang.dao;

import com.kuang.pojo.Student;
import com.kuang.pojo.Teacher;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class MyTest {
    static Logger logger = Logger.getLogger(MyTest.class);


    //获取teacher列表   打印日志版
    @Test
    public void getTeacher() {
        //获取session对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行sql    getMapper方式
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);

        logger.info(teacher);

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void getUserAndTeacher() {
        //获取session对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行sql    getMapper方式
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudent();
        for (Student student : students) {

            logger.info(student);
        }

        //关闭sqlSession
        sqlSession.close();
    }


}
