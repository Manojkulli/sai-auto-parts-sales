package com.sai.automobiles.project.controllers;

import com.sai.automobiles.project.dto.Product;
import com.sai.automobiles.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/saveProduct")
    public void saveProduct(@RequestBody Product product){
        productService.saveUser(product);
    }
}
