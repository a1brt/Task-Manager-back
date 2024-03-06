package com.albert.taskmanager.users.domain;

import com.albert.taskmanager.users.application.command.CreateUserCommand;
import com.albert.taskmanager.util.UuidGenerator;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {
    private final UuidGenerator uuidGenerator;

    public UserFactory(UuidGenerator uuidGenerator) {
        this.uuidGenerator = uuidGenerator;
    }

    public User createUser(CreateUserCommand command){
        return new User(
                uuidGenerator.newUUID(),
                command.getUsername(),
                command.getName(),
                command.getEmail(),
                command.getPassword(),
                true
        );
    }
}
