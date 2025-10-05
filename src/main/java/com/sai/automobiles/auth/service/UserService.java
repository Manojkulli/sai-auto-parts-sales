package com.sai.automobiles.auth.service;

import com.sai.automobiles.auth.dao.UserDao;
import com.sai.automobiles.auth.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public ResponseEntity<User> saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        User responseUser = userDao.saveUser(user);
       return new ResponseEntity<User>(responseUser, HttpStatus.CREATED);
    }

    public String isUserAuthenticated(User user) throws UsernameNotFoundException {
       Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
       if (authentication.isAuthenticated()){
           return jwtService.genrateToken(user);
       }
       return "user not found";
    }
}
