package com.example.ming.rpc.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: wangzhx
 * @create: 2020-10-17 14:51
 */
@Data
public class Product implements Serializable {
    private String id;
    private String name;
}