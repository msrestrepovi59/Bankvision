package com.BankVision.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.BankVision.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	
}
