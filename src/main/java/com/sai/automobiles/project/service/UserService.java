package com.sai.automobiles.project.service;

import com.sai.automobiles.project.dao.UserDao;
import com.sai.automobiles.project.dto.ResponseDto;
import com.sai.automobiles.project.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public ResponseEntity<User> saveUser(User user){
        User responseUser = userDao.saveUser(user);
       return new ResponseEntity<User>(responseUser, HttpStatus.CREATED);
    }

}
