package com.blog.dao;

import com.blog.model.User;

import java.util.List;

/**
 * Created by semen on 13.04.2016.
 */
public interface UserDao {

    User findById(int id);

    User findBySSO(String sso);

    void save(User user);

    List<User> getAllUsers();

    void delete(User user);

    void updateUser(User user);

}