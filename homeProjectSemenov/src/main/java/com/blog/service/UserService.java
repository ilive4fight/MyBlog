package com.blog.service;

import com.blog.model.User;

import java.util.List;

/**
 * Created by semen on 13.04.2016.
 */
public interface UserService {

    User findById(int id);

    User findBySso(String sso);

    void save(User user);

    List<User> getAllUsers();

    void deleteUser(User user);

    void updateUser(User user);


}