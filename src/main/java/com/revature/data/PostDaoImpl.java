package com.revature.data;

import com.revature.models.Post;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Repository
public class PostDaoImpl implements PostDao{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Post add(Post obj) {
        return null;
    }

    @Override
    public Collection<Post> all() {
        return null;
    }

    @Override
    public Post find(Serializable id) {
        String hql = "FROM Post p WHERE p.id = :idNum";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("idNum", id);
        return (Post)query.uniqueResult();
    }

    public List<Post> all(int userId){
        String hql = "FROM Post p WHERE p.user.id = :userId";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("userId", userId);
        return (List<Post>)query.list();
    }
}
