package com.nala.pet.user;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<UserDto> fetchUserById(@PathVariable(value = "userId") String userId){
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return  new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED); }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable(value = "userId") String userId, @Valid @RequestBody UserDto userDto){
        return  new ResponseEntity<>(userService.updateUser(userId, userDto), HttpStatus.OK);
    }

}
