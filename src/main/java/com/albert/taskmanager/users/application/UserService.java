package com.albert.taskmanager.users.application;

import com.albert.taskmanager.users.adapter.out.UserRepository;
import com.albert.taskmanager.users.application.command.CreateUserCommand;
import com.albert.taskmanager.users.domain.User;
import com.albert.taskmanager.users.domain.UserFactory;
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
