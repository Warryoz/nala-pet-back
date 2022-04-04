package com.nala.pet.user;

import com.nala.pet.pet.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class UserDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private Gender gender;
    private List<Pet> pets;
}
