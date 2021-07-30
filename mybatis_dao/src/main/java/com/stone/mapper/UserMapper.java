package com.stone.mapper;

import com.stone.domain.User;

public interface UserMapper {
    /*
        根据Id查询用户
     */
    public User findById(int id);
}
