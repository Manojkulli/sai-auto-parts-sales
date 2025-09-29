package com.sai.automobiles.project.dao;

import com.sai.automobiles.project.config.MongoService;
import com.sai.automobiles.project.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserDao {

    @Autowired
    private MongoService mongoService;

    @Autowired
    Environment environment;

    public User saveUser(User user){
        user.setId("USER_"+UUID.randomUUID());
        MongoTemplate mongoTemplate = mongoService.getMongoTempate(environment.getProperty("mongo.authdb"));
        return mongoTemplate.save(user);
    }
}
