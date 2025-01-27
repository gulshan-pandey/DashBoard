package com.User.Dashboard.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserLogin {

        @RequestMapping("/login")
        public String login() {
            return "User Logged In";
        }

        @RequestMapping("/logout")
        public String logout() {
            return "User Logged Out";
        }

}
