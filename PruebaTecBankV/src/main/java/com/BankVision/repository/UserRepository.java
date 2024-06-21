package com.BankVision.repository;

import com.BankVision.PruebaTecBankV.User;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	User findByInum(String numeroIdentifacion);
	User findByInumAndPass(String numid, String contrasena);
	
}
