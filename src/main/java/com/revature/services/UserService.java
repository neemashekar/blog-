package com.revature.services;

import com.revature.data.BaseDao;
import com.revature.data.UserDao;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    BaseDao<User> userDao;
    @Autowired
    public void setUserDao(BaseDao<User> userDao) {
        this.userDao = userDao;
    }
    @Transactional
    public User createUser(User user){
        return userDao.add(user);
    }
    @Transactional(readOnly = true)
    public User findUser(String username){
        User user = new User();
        user = ((UserDao)userDao).findByUsername(username);
        return user;
    }
}
