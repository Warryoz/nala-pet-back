package com.nala.pet.user;

import com.nala.pet.pet.Pet;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Data
@Document
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private Address address;
    private Gender gender;
    private List<Pet> pets;

    public User(String firstName, String lastName, String email, Address address, Gender gender, List<Pet> pets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.pets = pets;
    }
}
