package com.revature.controllers;

import com.revature.models.Post;
import com.revature.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<String> getPost(@PathVariable int id){
        Post p = postService.getPostById(id);
        String content = "<!DOCTYPE html><html>" +
                "<head>" +
                "    <meta charset='utf-8'>" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>" +
                "    <meta name='description' content=''>" +
                "    <meta name='author' content=''>" +
                "    <title class='fill_with_username'>"+p.getUser().getUsername()+"</title>" +
                "    <!-- Bootstrap core CSS -->" +
                "    <link href='vendor/bootstrap/css/bootstrap.min.css' rel='stylesheet'>" +
                "    <!-- Custom fonts for this template -->" +
                "    <link href='vendor/font-awesome/css/font-awesome.min.css' rel='stylesheet' type='text/css'>" +
                "    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>" +
                "    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>" +
                "    <!-- Custom styles for this template -->" +
                "    <link href='css/clean-blog.min.css' rel='stylesheet'>" +
                "</head>" +
                "<body>" +
                "<!-- Navigation -->" +
                "<nav class='navbar navbar-expand-lg navbar-light fixed-top' id='mainNav'>" +
                "    <div class='container'>" +
                "        <a class='navbar-brand fill_with_username' href='index.html'>"+p.getUser().getUsername()+"</a>" +
                "        <button class='navbar-toggler navbar-toggler-right' type='button' data-toggle='collapse' data-target='#navbarResponsive' aria-controls='navbarResponsive' aria-expanded='false' aria-label='Toggle navigation'>" +
                "            Menu" +
                "            <i class='fa fa-bars'></i>" +
                "        </button>" +
                "        <div class='collapse navbar-collapse' id='navbarResponsive'>" +
                "            <ul class='navbar-nav ml-auto'>" +
                "                <li class='nav-item'>" +
                "                    <a class='nav-link' href='index.html'>Home</a>" +
                "                </li>" +
                "                <li class='nav-item'>" +
                "                    <a class='nav-link' href='about.html'>About</a>" +
                "                </li>" +
                "                <li class='nav-item'>" +
                "                    <a class='nav-link' href='new.html'>Create New Post</a>" +
                "                </li>" +
                "                <li class='nav-item'>" +
                "                    <a class='nav-link' href='contact.html'>Contact</a>" +
                "                </li>" +
                "            </ul>" +
                "        </div>" +
                "    </div>" +
                "</nav>" +
                "<!-- Page Header -->" +
                "<header class='masthead' style='background-image: url('img/post-bg.jpg')'>" +
                "    <div class='overlay'></div>" +
                "    <div class='container'>" +
                "        <div class='row'>" +
                "            <div class='col-lg-8 col-md-10 mx-auto'>" +
                "                <div class='post-heading'>" +
                "                    <h1 class = 'title'>"+ p.getTitle() +"</h1>" +
                "                    <!--TODO: subheading-->" +
                "                    <!--<h2 id = 'subtitle' class='subheading'>Problems look mighty small from 150 miles up</h2>-->" +
                "                    <span class='meta'>Posted by" +
                "                        <!--TODO: grab user-->" +
                "                <a class='fill_with_username' href='#'>"+ p.getUser().getUsername() +"</a>" +
                "                        <!--TODO: grab date-->" +
                "                on August 24, 2018</span>" +
                "                </div>" +
                "            </div>" +
                "        </div>" +
                "    </div>" +
                "</header>" +
                "<!-- Post Content -->" +
                "<article>" +
                "    <div class='container'>" +
                "        <div class='row'>" +
                "            <!--TODO: grab content/format it-->" +
                "            <div class='col-lg-8 col-md-10 mx-auto' id='fill_with_post_body'>" +
                "                " + p.getBody() +
                "            </div>" +
                "        </div>" +
                "    </div>" +
                "</article>" +
                "<hr>" +
                "<!-- Footer -->" +
                "<footer>" +
                "    <div class='container'>" +
                "        <div class='row'>" +
                "            <div class='col-lg-8 col-md-10 mx-auto'>" +
                "                <ul class='list-inline text-center'>" +
                "                    <li class='list-inline-item'>" +
                "                        <a href='#'>" +
                "                  <span class='fa-stack fa-lg'>" +
                "                    <i class='fa fa-circle fa-stack-2x'></i>" +
                "                    <i class='fa fa-twitter fa-stack-1x fa-inverse'></i>" +
                "                  </span>" +
                "                        </a>" +
                "                    </li>" +
                "                    <li class='list-inline-item'>" +
                "                        <a href='#'>" +
                "                  <span class='fa-stack fa-lg'>" +
                "                    <i class='fa fa-circle fa-stack-2x'></i>" +
                "                    <i class='fa fa-facebook fa-stack-1x fa-inverse'></i>" +
                "                  </span>" +
                "                        </a>" +
                "                    </li>" +
                "                    <li class='list-inline-item'>" +
                "                        <a href='#'>" +
                "                  <span class='fa-stack fa-lg'>" +
                "                    <i class='fa fa-circle fa-stack-2x'></i>" +
                "                    <i class='fa fa-github fa-stack-1x fa-inverse'></i>" +
                "                  </span>" +
                "                        </a>" +
                "                    </li>" +
                "                </ul>" +
                "                <p class='copyright text-muted'>Copyright &copy; Your Website 2018</p>" +
                "            </div>" +
                "        </div>" +
                "    </div>" +
                "</footer>" +
                "</body>" +
                "</html>";

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity<String>(content, responseHeaders, HttpStatus.OK);
    }

    @GetMapping(path = "/id={id}")
    public ResponseEntity<Post> getPostObject(@PathVariable int id){
        Post p = postService.getPostById(id);

        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping(path = "/user/user_id={userId}&page={page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Post>> getPost(@PathVariable int userId, @PathVariable int page){
        List<Post> p = postService.getPostsByUserId(userId, page);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}
