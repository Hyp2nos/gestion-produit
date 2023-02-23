package com.example.test.services;

import com.example.test.entites.Products;
import com.example.test.service.ProductImplementation;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductImplementationTests {

    @Autowired
    private ProductImplementation;




    @Test
    public void saveProductWithSucess(){
        Products product = new Products("azaza","fifa",22.0,"un test");
        Products productSave = productImplementation.saveProduct(product);

        assertNotNull(productSave);
        assertNotNull(productSave.getId());
        assertEquals(product.getName(), productSave.getName());
        assertEquals(product.getPrice(), productSave.getPrice());
        assertEquals(product.getDescription(), productSave.getDescription());
    }
}
