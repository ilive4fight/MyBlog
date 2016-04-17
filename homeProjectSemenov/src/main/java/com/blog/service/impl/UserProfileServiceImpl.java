package com.blog.service.impl;

import com.blog.dao.UserProfileDao;
import com.blog.model.UserProfile;
import com.blog.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by semen on 13.04.2016.
 */
@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileDao dao;

    public List<UserProfile> findAll() {
        return dao.findAll();
    }

    public UserProfile findByType(String type){
        return dao.findByType(type);
    }

    public UserProfile findById(int id) {
        return dao.findById(id);
    }
}