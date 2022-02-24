package com.castillo.fullstackbooks.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.castillo.fullstackbooks.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	//magic jpa methods. for more info https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
	
	    
	    Optional<User> findByEmail(String email);
	    

	

}
