package com.sai.automobiles.project.config;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MongoConfig {

    @Autowired
    Environment environment;

    @Bean("mongoClient")
    public MongoClient getMongoClient() {
        return MongoClients.create(environment.getProperty("mongo.connection.url"));
    }
}

