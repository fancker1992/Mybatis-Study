package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);


    //获取用户列表
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


}
