package com.sai.automobiles.project.dao;

import com.sai.automobiles.project.config.MongoService;
import com.sai.automobiles.project.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ProductDao {

    @Autowired
    private MongoService mongoService;

    public void saveProduct(Product product){
       product.setId("PRODUCT_"+ UUID.randomUUID());
       MongoTemplate mongoTemplate = mongoService.getMongoTempate("LIC1001");
       mongoTemplate.save(product,"products");
    }
}
