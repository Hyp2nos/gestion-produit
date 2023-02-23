package com.example.test.web;

import com.example.test.entites.Products;
import com.example.test.service.ProductImplementation;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class Controller {

    final ProductImplementation productImplementation;

    public Controller(ProductImplementation productImplementation) {
        this.productImplementation = productImplementation;
    }

    @GetMapping("/product")
    public List<Products> getAll(){return productImplementation.findAll();}

    @GetMapping("/product/{id}")
    public Products getOneById(@PathVariable(name = "id") String id){return productImplementation.findById(id);}

    @PostMapping("/product")
    public void creat(@RequestBody Products products){
        productImplementation.saveProduct(products);
    }

    @PutMapping("/product")
    public void update(@RequestBody Products products){
        productImplementation.updateProduct(products);
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable(name="id") String id){
        productImplementation.deleteById(id);
    }

}
