package com.nala.pet.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> fetchAllUser(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDto fetchUserById(@PathVariable(value = "userId") String userId){ return  userService.getUserById(userId); }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto){ return userService.createUser(userDto); }

    @PutMapping("/{userId}")
    public UserDto updateUser(@PathVariable(value = "userId") String userId, @RequestBody UserDto userDto){
        return userService.updateUser(userId, userDto);
    }

}
