package com.nala.pet.pet;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pet {
    private String name;
    private String birthDate;
    private String race;

}
