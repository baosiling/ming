package com.example.ming.rpc.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: wangzhx
 * @create: 2020-10-17 09:44
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String name;

    public User(){

    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}