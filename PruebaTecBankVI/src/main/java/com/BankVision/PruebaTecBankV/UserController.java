package com.BankVision.PruebaTecBankV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.BankVision.factory.UserFactory;
import com.BankVision.model.User;
import com.BankVision.repository.UserRepository;
import com.BankVision.service.UserService;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
	
	
	private UserService userService;
	
    

   @PostMapping
   public User createUser(@RequestBody User user) {
       User newUser = UserFactory.createUser(user.getNumeroIdentificacion(), user.getTipoIdentificacion(), user.getFechaNacimiento(), user.getTelefono(), user.getCorreo(), user.getContrasena());
       return userService.saveUser(newUser);
   }

   @GetMapping("/{numeroIdentifacion}")
   public ResponseEntity<User> getUserBynumid(@PathVariable String numeroIdentifacion) {
	   return userService.getUserBynum(numeroIdentifacion).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
   }

   @GetMapping
   public ResponseEntity<List<User>> getAllUsers() {
       return ResponseEntity.ok(userService.getAllUsers());
   }

   @PutMapping("/{numeroIdentifacion}")
   public ResponseEntity<User> updateUser(@PathVariable String numeroIdentifacion, @RequestBody User user) {
       user.setNumeroIdentificacion(numeroIdentifacion);
       User updatedUser = userService.updateUser(user);
       return ResponseEntity.ok(updatedUser);
   }

   @DeleteMapping("/{numeroIdentifacion}")
   public ResponseEntity<Void> deleteUser(@PathVariable String numeroIdentifacion) {
       userService.deleteUser(numeroIdentifacion);
       return ResponseEntity.noContent().build();
   }

  
   
}