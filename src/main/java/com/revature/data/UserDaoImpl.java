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
        String hql = "from User where User.username = :u";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("u",username);
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
        return null;
    }
}
