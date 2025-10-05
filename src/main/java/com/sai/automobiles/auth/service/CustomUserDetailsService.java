package com.sai.automobiles.auth.service;

import com.sai.automobiles.auth.dao.UserDao;
import com.sai.automobiles.auth.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByName(username);
        if (Objects.nonNull(user)){
            return new UserDetailsImpl(user);
        }
        throw new UsernameNotFoundException("user not found");
    }
}
