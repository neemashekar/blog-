package com.revature.data;

import com.revature.models.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public User findByUsername(String username) {
        String hql = "from User Where username =:u";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("u",username);
        return null;

//        sessionFactory.getCurrentSession().save(query);
    }

    @Override
    public User add(User obj) {
        return null;
    }

    @Override
    public Collection<User> all() {
        return null;
    }

    @Override
    public User find(Serializable id) {
        return null;
    }
}
