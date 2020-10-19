package com.example.ming.rpc.r03;

import com.example.ming.rpc.common.IProductService;
import com.example.ming.rpc.common.IUserService;
import com.example.ming.rpc.common.Product;
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

        IProductService productService = Stub.getStub(IProductService.class);
        Product product = productService.findById("1234");
        System.out.println(product);
    }
}