package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
@ResponseBody
public class UserController {
    UserService us;
    @Autowired
    public void setUs(UserService us) {
        this.us = us;
    }
    @GetMapping(path="/show", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(){
        User user= us.findUser("neema");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
