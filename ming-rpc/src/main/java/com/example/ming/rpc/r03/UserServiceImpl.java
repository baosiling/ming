package com.example.ming.rpc.r03;

import com.example.ming.rpc.common.IUserService;
import com.example.ming.rpc.common.User;

/**
 * @description:
 * @author: wangzhx
 * @create: 2020-10-17 09:49
 */
public class UserServiceImpl implements IUserService {
    @Override
    public User findById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("hhhh");
        return user;
    }
}