package com.example.test;

import com.example.test.entites.Products;
import com.example.test.service.ProductImplementation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TestApplication{

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            ProductImplementation productImplementation
    ){
        return args -> {
            Products products = new Products("tetsd","fifa",22.0,"gfds");
            productImplementation.saveProduct(products);

        };

    }

}
