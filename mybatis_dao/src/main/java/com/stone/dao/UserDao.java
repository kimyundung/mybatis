package com.stone.dao;

import com.stone.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    /*
        查询所有
     */
    public List<User> findAll() throws IOException;
}
