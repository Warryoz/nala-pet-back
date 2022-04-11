package com.nala.pet.pet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {
    private String id;
    private String name;
    private Boolean hasVaccineUpdated;
    private String birthDate;
    private String race;
}
