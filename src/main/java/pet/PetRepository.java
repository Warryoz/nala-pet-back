package pet;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetRepository extends MongoRepository<Pet, String> {}
