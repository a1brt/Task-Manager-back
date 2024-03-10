package com.albert.taskmanager.services;

import com.albert.taskmanager.repositories.UserRepository;
import com.albert.taskmanager.commands.CreateUserCommand;
import com.albert.taskmanager.domain.entities.User;
import com.albert.taskmanager.domain.factories.UserFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserFactory userFactory;

    public UserService(UserRepository userRepository, UserFactory userFactory) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
    }

    public void createUser(CreateUserCommand command){
        User user = userFactory.createUser(command);
        userRepository.save(user);
    }
}
