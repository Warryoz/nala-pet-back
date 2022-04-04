package com.nala.pet.pet;

import com.nala.pet.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document
public class Pet {
    @Id
    private String id;
    private String name;
    private Boolean hasVaccineUpdated;
    private String birthDate;
    private String race;
    private List<User> owners;
}
