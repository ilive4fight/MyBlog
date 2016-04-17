package com.blog.service.impl;

import com.blog.model.User;
import com.blog.model.UserProfile;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by semen on 13.04.2016.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
        User user = userService.findBySso(ssoId);
        if (user == null) {
            System.out.println("UserNotFound");
            throw new UsernameNotFoundException("UserName not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getSsoId(), user.getPassword(), user.getState().equals("Active"), true, true, true, getGrantedAutorities(user));

    }

    private List<GrantedAuthority> getGrantedAutorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(UserProfile userProfile : user.getUserProfiles()){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
        }
        return authorities;
    }


}
