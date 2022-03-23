package com.nala.pet;

import com.nala.pet.pet.Pet;
import com.nala.pet.user.Address;
import com.nala.pet.user.Gender;
import com.nala.pet.user.User;
import com.nala.pet.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootApplication
public class NalaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NalaApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepository userRepository,
							  MongoTemplate mongoTemplate){
		return args -> {
			Pet pet = new Pet(
					"Nala",
					"2018-7-19",
					"Mix"
			);
			Pet pet2 = new Pet(
					"Marceline",
					"2016-7-19",
					"Pug"
			);
			Address address = new Address(
					"Colombia",
					"12312312",
					"Bogotá"
			);
			User user = new User(
					"Gero",
					"chan",
					"mimo@hotmail.com",
					address,
					Gender.MALE,
					List.of(pet, pet2)
			);
			userRepository.findUserByEmail(user.getEmail())
					.ifPresentOrElse(s ->{
						System.out.println("EMAIL DUPLICATED");
					}, () ->{
						System.out.println("INSERTING USER == "+ user);
						userRepository.insert(user);
					});
			//extracted(userRepository, mongoTemplate, user);

		};
	}

	/*private void usingMongoTemplate(UserRepository userRepository, MongoTemplate mongoTemplate, User user) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(user.getEmail()));
		List<User> users = mongoTemplate.find(query, User.class);
		if(users.size() > 1){
			throw new IllegalStateException(
					"Email duplicated"+ user.getEmail());
		}

		if(users.isEmpty()){
			System.out.println("INSERTING STUDENT"+ user);
			userRepository.insert(user);
		}else{
			System.out.println("Already exists");
		}
	}*/
}
