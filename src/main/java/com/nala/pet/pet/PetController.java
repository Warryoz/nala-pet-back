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
    public List<Pet> fetchAllPets(){
        return petService.getAllPets();
    }

    @GetMapping("/{petId}")
    public Pet fetchUserById(@PathVariable(value = "id") String id){ return petService.getPetById(id); }

    @PostMapping
    public Pet createPet(@RequestBody Pet pet){ return petService.createPet(pet); }

    @PutMapping
    public Pet updatePet(@RequestBody Pet pet){ return petService.updatePet(pet); }
}
