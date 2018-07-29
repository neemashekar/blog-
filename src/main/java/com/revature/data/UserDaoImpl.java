package com.revature.data;

import com.revature.models.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;

@Repository
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public User findByUsername(String username) {
        String hql = "FROM User U WHERE U.username = :un";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("un",username);
        return (User)query.uniqueResult();
    }

    @Override
    public User add(User user) {
        Integer id = (Integer)sessionFactory.getCurrentSession().save(user);
        user.setId(id);
        return user;

    }

    @Override
    public Collection<User> all() {
        return null;
    }

    @Override
    public User find(Serializable id) {
        String hql = "FROM User U WHERE U.id = :id";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("id",id);
        return (User)query.uniqueResult();
    }
}
