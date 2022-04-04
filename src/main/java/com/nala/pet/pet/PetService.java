package com.nala.pet.pet;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    Pet getPetById(String id) {
        return petRepository.findById(id).get();
    }

    Pet createPet(Pet pet) {
        return petRepository.insert(pet);
    }

    Pet updatePet(Pet pet) {
        return petRepository.insert(pet);
    }
}

