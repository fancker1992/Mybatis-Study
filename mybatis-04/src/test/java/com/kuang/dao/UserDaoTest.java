package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);


    //获取用户列表   打印日志版
    @Test
    public void test() {
        //获取session对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行sql    getMapper方式
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
//            System.out.println(user);
            logger.info(user); //使用logger 中的 info
        }

        //关闭sqlSession
        sqlSession.close();
    }

    //分页
    @Test
    public void getUserListByLimit() {
        //获取session对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行sql    getMapper方式
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);

        List<User> userList = userDao.getUserListByLimit(map);
        for (User user : userList) {
            logger.info(user);

        }
    }


}
