package com.nala.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String id;
    @NotEmpty(message = "firstName may not be empty")
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private Gender  gender;
}
