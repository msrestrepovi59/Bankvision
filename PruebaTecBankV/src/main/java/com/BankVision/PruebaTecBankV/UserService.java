package com.BankVision.PruebaTecBankV;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.BankVision.repository.UserRepository;

import java.util.List;


@Service
public class UserService {

   // @Autowired
    private UserRepository userRepository;
    
   // @Autowired
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

    public User login(String numeroIdentificacion, String contrasena) {
        return userRepository.findByInumAndPass(numeroIdentificacion, contrasena);
    }
    
   
}
