package com.albert.taskmanager.users.application;

import com.albert.taskmanager.users.adapter.out.UserRepository;
import com.albert.taskmanager.users.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetails implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("Not found");
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), List.of());
    }
}
