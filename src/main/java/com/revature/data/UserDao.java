package com.revature.data;

import com.revature.models.User;

public interface UserDao extends BaseDao <User> {
    User findByUsername(String username);

//    User add(User user);
//
//    Collection<User> all();
//
//    User find(Serializable id);
}
