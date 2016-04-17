package com.blog.dao.impl;

import com.blog.dao.AbstractDao;
import com.blog.dao.UserDao;
import com.blog.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by semen on 13.04.2016.
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    public User findById(int id) {
        return getByKey(id);
    }

    public User findBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        return (User) crit.uniqueResult();
    }

    public void save(User user) {
        persist(user);
    }

    public List<User> getAllUsers(){
     return  getAll(User.class);
    }

    public void deleteUser(User user){
        delete(user);
    }

    public void updateUser(User user) {
        User updatedUser = findById(user.getId());
        deleteUser(updatedUser);
       updatedUser.setSsoId(user.getSsoId());
        updatedUser.setPassword(user.getPassword());
       updatedUser.setUserProfiles(user.getUserProfiles());
        save(updatedUser);
    }

}