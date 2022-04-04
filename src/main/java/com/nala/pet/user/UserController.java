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
    public List<User> fetchAllUser(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User fetchUserById(@PathVariable(value = "userId") String id){ return  userService.getUserById(id); }

    @PostMapping
    public User createUser(@RequestBody User user){ return userService.createUser(user); }

    @PutMapping
    public User updateUser(@RequestBody User user){ return userService.updateUser(user); }

}
