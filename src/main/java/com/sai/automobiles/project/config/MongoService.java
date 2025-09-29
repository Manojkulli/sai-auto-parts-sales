package com.sai.automobiles.project.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoService {

    @Autowired
    private MongoClient mongoClient;

    public MongoTemplate getMongoTempate(String dbName){
       mongoClient.getDatabase(dbName);
       return new MongoTemplate(mongoClient,dbName);
    }
}
