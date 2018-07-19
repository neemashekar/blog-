package com.revature.data;

import com.revature.models.User;

import java.io.Serializable;
import java.util.Collection;

public interface UserDao extends BaseDao <User> {
    User findByUsername(String username);

    @Override
    User add(User obj);

    @Override
    Collection<User> all();

    @Override
    User find(Serializable id);
}
