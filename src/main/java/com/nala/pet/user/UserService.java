package com.nala.pet.user;

import com.nala.pet.pet.Pet;
import com.nala.pet.shared.config.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Set;
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
        System.out.println(userDto.getId());
        System.out.println(userDto.getEmail());
        System.out.println(userDto.getFirstName());
        User user = mapToEntity(userDto);
        System.out.println(user.getId());
        System.out.println(user.getEmail());
        System.out.println(user.getFirstName());
        User newUser = userRepository.insert(user);
        return mapToDto(newUser);
    }

    UserDto updateUser(String userId, UserDto userDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));;
        user.setFirstName(userDto.getFirstName());
     //   user.setLastName(userDto.getLastName());
   //   user.setAddress(userDto.getAddress());
        user.setEmail(userDto.getEmail());
 //       user.setGender(userDto.getGender());
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
