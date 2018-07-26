//package com.revature;
//
//import org.junit.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//@Component("tester")
//@Configuration
//@PropertySource("classpath:db.properties")
//@EnableTransactionManagement
//@ComponentScan("com")
//@EnableWebMvc
//public class PostControllerTest {
//
//    @Autowired
//    public PostControllerTest() {
//    }
//
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(); // this is where the bean are kept
//        context.register(PostControllerTest.class);
//        context.refresh();
//
////        PostControllerTest tester = context.getBean("tester", WebConfig.class);
//
//    }
//
//}
