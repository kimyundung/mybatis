package com.stone.test;

import com.stone.dao.UserDao;
import com.stone.dao.impl.UserDaoImpl;
import com.stone.domain.User;
import org.junit.Test;

import java.io.IOException;
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
}
