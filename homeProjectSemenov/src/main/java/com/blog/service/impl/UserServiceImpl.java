package com.blog.service.impl;

import com.blog.dao.UserDao;
import com.blog.model.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by semen on 13.04.2016.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDao dao;

    public User findById(int id) {
        return dao.findById(id);
    }

    public User findBySso(String sso) {
        return dao.findBySSO(sso);
    }

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
    }

    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    public  void deleteUser(User user){
        dao.delete(user);
    }

    public void updateUser(User user) {
        dao.updateUser(user);
    }

}