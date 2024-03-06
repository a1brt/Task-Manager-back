package com.albert.taskmanager.users.adapter.in.controller;

import com.albert.taskmanager.users.application.UserService;
import com.albert.taskmanager.users.application.command.CreateUserCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void register(@RequestBody CreateUserCommand request){
        userService.createDefaultUser(request);
    }
}
