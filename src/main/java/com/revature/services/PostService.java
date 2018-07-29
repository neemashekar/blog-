package com.revature.services;

import com.revature.data.BaseDao;
import com.revature.data.PostDaoImpl;
import com.revature.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    PostDaoImpl postDao;

    @Autowired
    public void setPostDao(PostDaoImpl postDao) {
        this.postDao = postDao;
    }

    @Transactional
    public Post getPostById(int id){
        return postDao.find(id);
    }

    @Transactional
    public List<Post> getPostsByUserId(int userId, int page){
        List<Post> result = postDao.all(userId);
        List<Post> ret;

        if(result.size() > 5){
            if(result.size() >= (page-1)*5 ){
                if(result.size() < page*5+1){
                    ret = result.subList((page-1)*5, result.size());
                } else {
                    ret = result.subList((page-1)*5,page*5);
                }
            } else {
                ret = result.subList(0,5);
            }
        } else {
            ret = result;
        }

        return ret;
    }
}
