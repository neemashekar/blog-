package com.revature.services;

import com.revature.data.BaseDao;
import com.revature.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {
    BaseDao<Post> postDao;

    @Autowired
    public void setPostDao(BaseDao<Post> postDao) {
        this.postDao = postDao;
    }

    @Transactional
    public Post getPostById(int id){
        return postDao.find(id);
    }
}
