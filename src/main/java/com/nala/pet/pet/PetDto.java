package com.nala.pet.pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {
    private String id;
    private String name;
    private Boolean hasVaccineUpdated;
    private String birthDate;
    private String race;
}
