package com.BankVision.PruebaTecBankV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.BankVision.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {
	
	//@Autowired
	private UserService userService;
	//@Autowired
    private UserRepository userRepository;
    

   @PostMapping("/signup")
   public User createUser(@RequestBody User user) {
       User newUser = UserFactory.createUser(user.getNumeroIdentificacion(), user.getTipoIdentificacion(), user.getFechaNacimiento(), user.getTelefono(), user.getCorreo(), user.getContrasena());
       return userRepository.save(newUser);
   }

   @GetMapping("/{numeroIdentifacion}")
   public ResponseEntity<User> getUserBynumid(@PathVariable String numeroIdentifacion) {
	   return userRepository.findById(numeroIdentifacion).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
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

   @PostMapping("/login")
   public ResponseEntity<User> login(@RequestBody User loginRequest) {
       User user = userService.login(loginRequest.getNumeroIdentificacion(), loginRequest.getContrasena());
       if (user != null) {
           return ResponseEntity.ok(user);
       } else {
           return ResponseEntity.status(401).build();
       }
   }
}