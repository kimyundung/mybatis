package com.stone.test;

import com.stone.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class MybatisTest {

    @Test
    public void mybatisQuickStart() throws IOException {

        // 1. 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 2. 获取sqlSessionFactory工厂对象 (sqlSession是会话对象)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 3. 获取sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4. 执行sql : 参数 -> statementId -> namespace.id
        List<User> userList = sqlSession.selectList("user.findAll");

        // 5. 遍历打印
        for (User user : userList) {
            System.out.println(user);
        }

        // 6. 关闭资源
        sqlSession.close();
    }
}
