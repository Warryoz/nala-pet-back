package pet;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PetDto> fetchUserById(@PathVariable(value = "petId") String petId){
        return new ResponseEntity<>(petService.getPetById(petId), HttpStatus.OK); }

    @PostMapping
    public ResponseEntity<PetDto> createPet(@RequestBody PetDto petDto){
        return new ResponseEntity<>(petService.createPet(petDto), HttpStatus.CREATED);
    }

    @PutMapping("/{petId}")
    public ResponseEntity<PetDto> updatePet(@PathVariable(value = "petId") String petId, @RequestBody PetDto petDto){
        return new ResponseEntity<>(petService.updatePet(petId, petDto), HttpStatus.OK);
    }
}
