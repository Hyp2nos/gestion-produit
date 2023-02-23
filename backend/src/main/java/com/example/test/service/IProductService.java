package com.example.test.service;

import com.example.test.entites.Products;

import java.util.List;

public interface IProductService {
    List<Products> findAll();
    Products findById(String id);
    void deleteById(String id);
    void saveProduct(Products product);
    void updateProduct(Products products);
}
