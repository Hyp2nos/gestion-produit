package com.example.test.service;

import com.example.test.entites.Products;
import com.example.test.repositories.ProductRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductImplementation implements IProductService {

    final ProductRepositories productRepositories;

    public ProductImplementation(ProductRepositories productRepositories) {
        this.productRepositories = productRepositories;
    }

    @Override
    public List<Products> findAll() {
        return productRepositories.findAll();
    }

    @Override
    public Products findById(String id) {
        return productRepositories.findById(id).get();
    }

    @Override
    public void deleteById(String id) {
        productRepositories.deleteById(id);

    }

    @Override
    public Products saveProduct(Products product) {
        Products prod = productRepositories.findByName(product.getName());
        if (prod == null) {
            product.setId(UUID.randomUUID().toString().split("-")[0]);
            productRepositories.save(product);
        }
        else throw new IllegalArgumentException("Le produits existe deja ");

        return prod;
    }

    @Override
    public void updateProduct(Products products) {
        Products prod = productRepositories.findById(products.getId()).get();
        prod.setName(products.getName());
        prod.setDescription(products.getDescription());
        prod.setPrice(products.getPrice());
        productRepositories.save(prod);

    }
}
