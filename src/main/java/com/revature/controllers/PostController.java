package com.revature.controllers;

import com.revature.models.Post;
import com.revature.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/posts")
@ResponseBody
public class PostController {
    PostService postService;

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> getPost(@PathVariable int id){
        Post p = postService.getPostById(id);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping(path = "/user/user_id={userId}&page={page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Post>> getPost(@PathVariable int userId, @PathVariable int page){
        List<Post> p = postService.getPostsByUserId(userId, page);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}
