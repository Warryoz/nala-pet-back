package com.nala.pet.pet;

import com.nala.pet.shared.config.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PetService {
    private final PetRepository petRepository;
    private final ModelMapper mapper;

    List<PetDto>getAllPets (){
        return petRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    PetDto getPetById(String petId) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(()-> new ResourceNotFoundException("Pet", "id", petId));
        return mapToDto(pet);
    }

    PetDto createPet(PetDto petDto) {
        Pet pet = mapToEntity(petDto);
        Pet newPet = petRepository.save(pet);
        return mapToDto(newPet);
    }

    PetDto updatePet(String petId, PetDto petDto) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(()-> new ResourceNotFoundException("Pet", "id", petId));
        pet.setName(petDto.getName());
        pet.setBirthDate(petDto.getBirthDate());
        pet.setHasVaccineUpdated(petDto.getHasVaccineUpdated());
        pet.setRace(petDto.getRace());
        petRepository.save(pet);
        return mapToDto(pet);
    }

    PetDto mapToDto(Pet pet){
        return mapper.map(pet, PetDto.class);
    }

    Pet mapToEntity(PetDto petDto){
        return mapper.map(petDto, Pet.class);
    }
}

