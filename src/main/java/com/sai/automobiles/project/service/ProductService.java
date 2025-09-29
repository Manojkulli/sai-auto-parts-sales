package com.sai.automobiles.project.service;

import com.sai.automobiles.project.dao.ProductDao;
import com.sai.automobiles.project.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public void saveUser(Product product){
        productDao.saveProduct(product);
    }
}
