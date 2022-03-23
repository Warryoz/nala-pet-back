package com.nala.pet.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
