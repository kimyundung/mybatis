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
        // *****这里做了很重要的事啊*****
        // (1) 进行了初始化配置: 使用dom4j解析了配置文件, 将映射配置文件中的配置封装了一个一个的MappedStatement对象, 将这些MappedStatement对象封装成Map集合
        // (2) 创建了SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 3. 获取sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4. 执行sql : 参数 -> statementId -> namespace.id
        // sqlSession本身不会直接操作数据库, 委派给执行器来操作(Executor -> 执行JDBC代码), 参数statement就是Map集合中的key
        List<User> userList = sqlSession.selectList("userMapper.findAll");

        // 5. 遍历打印
        for (User user : userList) {
            System.out.println(user);
        }

        // 6. 关闭资源
        sqlSession.close();
    }

    @Test
    public void testSave() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User(57L,"mybatis","mybatis@stone","北京","women","1");
        int insert = sqlSession.insert("userMapper.saveUser", user);

        sqlSession.commit(); //手动提交事务
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User(57L,"mybatisUpdate","mybatisUpdate@stone","北京Update","womenUpdate","1");
        int update = sqlSession.update("userMapper.updateUser", user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDelete() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int delete = sqlSession.delete("userMapper.deleteUser", 57L);

        sqlSession.commit();
        sqlSession.close();
    }
}
