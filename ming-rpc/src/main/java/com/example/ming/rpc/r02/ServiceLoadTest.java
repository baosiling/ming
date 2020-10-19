package com.example.ming.rpc.r02;

import com.example.ming.rpc.common.IUserService;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @description:
 * @author: wangzhx
 * @create: 2020-10-17 15:56
 */
public class ServiceLoadTest {

    public static void main(String[] args) {
        ServiceLoader<IUserService> services = ServiceLoader.load(IUserService.class);
        Iterator<IUserService> serviceIterator = services.iterator();
        if(serviceIterator.hasNext()){
            IUserService userService = serviceIterator.next();
            System.out.println(userService);
        }
    }
}