package com.enjoy.service;

import com.enjoy.vo.Product;

import java.util.List;

public interface IProductService {
    Product get(long id);
    boolean add(Product product);
    List<Product> list();
}