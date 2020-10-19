package com.example.ming.rpc.r01;

import com.example.ming.rpc.common.IUserService;
import com.example.ming.rpc.common.User;

/**
 * @description:
 * @author: wangzhx
 * @create: 2020-10-17 09:49
 */
public class Client {

    public static void main(String[] args) {
        IUserService userService = Stub.getStub(IUserService.class);
        User user = userService.findById(123);
        System.out.println(user);
    }
}