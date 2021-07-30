package com.stone.test;

import com.stone.dao.UserDao;
import com.stone.dao.impl.UserDaoImpl;
import com.stone.domain.User;
import com.stone.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    /*
        mybatis的Dao层传统方法测试
     */
    @Test
    public void test1() throws IOException {
        UserDao userDao = new UserDaoImpl();
        List<User> userList = userDao.findAll();

        for (User user : userList) {
            System.out.println(user);
        }
    }

    /*
        mybatis的Dao层mapper代理开发方法测试
     */
    @Test
    public void test2() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 传统方法: 问题 -> statement的硬编码
        /*User user = sqlSession.selectOne("com.stone.mapper.UserMapper.findById", 1);
        System.out.println(user);*/

        // UserMapper代理对象的获取, 底层: JDK动态代理, 实际类型是: proxy
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findById(1);
        System.out.println(user);

    }
}
