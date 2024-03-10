package com.albert.taskmanager.domain.factories;

import com.albert.taskmanager.commands.CreateUserCommand;
import com.albert.taskmanager.domain.entities.User;
import com.albert.taskmanager.util.UuidGenerator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {
    private final UuidGenerator uuidGenerator;
    private final PasswordEncoder encoder;

    public UserFactory(UuidGenerator uuidGenerator, PasswordEncoder encoder) {
        this.uuidGenerator = uuidGenerator;
        this.encoder = encoder;
    }

    public User createUser(CreateUserCommand command){
        return new User(
                uuidGenerator.newUUID(),
                command.getUsername(),
                command.getName(),
                command.getEmail(),
                encoder.encode(command.getPassword()),
                true
        );
    }
}
