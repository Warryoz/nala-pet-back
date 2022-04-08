package com.nala.pet.pet;

import com.nala.pet.user.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/pets")
@AllArgsConstructor
public class PetController {

    private final PetService petService;
    @GetMapping
    public List<PetDto> fetchAllPets(){
        return petService.getAllPets();
    }

    @GetMapping("/{petId}")
    public PetDto fetchUserById(@PathVariable(value = "petId") String petId){ return petService.getPetById(petId); }

    @PostMapping
    public PetDto createPet(@RequestBody PetDto petDto){ System.out.println(petDto); return petService.createPet(petDto); }

    @PutMapping("/{petId}")
    public PetDto updatePet(@PathVariable(value = "petId") String petId, @RequestBody PetDto petDto){ return petService.updatePet(petId, petDto); }
}
