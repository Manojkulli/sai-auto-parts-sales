package com.sai.automobiles.auth.dao;

import com.sai.automobiles.project.config.MongoService;
import com.sai.automobiles.auth.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

    public User getUserByName(String username) {
        MongoTemplate mongoTemplate = mongoService.getMongoTempate(environment.getProperty("mongo.authdb"));
        Query query = Query.query(Criteria.where("userName").is(username));
        return mongoTemplate.findOne(query,User.class,"users");
    }
}
