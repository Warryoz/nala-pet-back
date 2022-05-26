package com.nala.user;

import com.nala.shared.config.security.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    List<UserDto> getAllUsers(){
        return userRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    UserDto getUserById(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return mapToDto(user);
    }

    UserDto createUser(UserDto userDto) {
        User user = mapToEntity(userDto);
        User newUser = userRepository.insert(user);
        return mapToDto(newUser);
    }

    UserDto updateUser(String userId, UserDto userDto) {
       User  user =  userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setAddress(user.getAddress());
        user.setGender(userDto.getGender());
        userRepository.save(user);
        return mapToDto(user);
    }

    UserDto mapToDto(User user){
        return mapper.map(user, UserDto.class);
    }

    User mapToEntity(UserDto user){
        return mapper.map(user, User.class);
    }

}
