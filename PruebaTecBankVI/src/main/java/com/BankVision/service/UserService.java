package com.BankVision.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.BankVision.model.User;
import com.BankVision.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    
    private UserRepository userRepository;
    
   
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    

    public User saveUser(User user) {
    	user.setContrasena(passwordEncoder.encode(user.getContrasena()));
        return userRepository.save(user);
    }

  
    public Optional<User> getUserBynum(String numeroIdentificacion) {
        return userRepository.findById(numeroIdentificacion);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }	

    public void deleteUser(String numeroIdentificacion) {
        userRepository.deleteById(numeroIdentificacion);
    } 
   
}
