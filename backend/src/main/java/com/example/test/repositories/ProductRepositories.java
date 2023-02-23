package com.example.test.repositories;

import com.example.test.entites.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ProductRepositories extends MongoRepository<Products, String> {

    Products findByName(String name);
}
