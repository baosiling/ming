package com.example.ming.rpc.r02;

import com.example.ming.rpc.common.IProductService;
import com.example.ming.rpc.common.Product;

/**
 * @description:
 * @author: wangzhx
 * @create: 2020-10-17 14:53
 */
public class ProductServiceImpl implements IProductService {
    @Override
    public Product findById(String id) {
        Product product = new Product();
        product.setId(id);
        product.setName("product001");
        return product;
    }
}