package com.albert.taskmanager.users.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateUserCommand {
    private String username;
    private String name;
    private String email;
    private String password;
}
