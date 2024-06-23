package com.BankVision.factory;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.BankVision.model.User;

public class UserFactory {

	
	@Autowired
	private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	 public static User createUser(String numeroIdentifacion,String tipoIdentificacion, LocalDate fechaNacimiento, String telefono, String correo, String contrasena) {
	        User user = new User();
	        user.setNumeroIdentificacion(numeroIdentifacion);
	        user.setTipoIdentificacion(tipoIdentificacion);
	        user.setFechaNacimiento(fechaNacimiento);
	        user.setTelefono(telefono);
	        user.setCorreo(correo);
	        user.setContrasena(passwordEncoder.encode(contrasena));
	        
	       
	        return user;
	    }
   
}
