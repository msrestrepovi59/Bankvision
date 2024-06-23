package com.BankVision.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.time.LocalDate;
import java.time.Period;


@Document(collection = "users")
public class User {

    @Id
    private String numeroIdentifacion;
    private String tipoIdentificacion;
    private LocalDate fechaNacimiento;
    private int edad;
    private String telefono;
    private String correo;
    private String contrasena;

    
   
    public String getNumeroIdentificacion() {
        return numeroIdentifacion;
    }

    public void setNumeroIdentificacion(String numeroIdentifacion) {
        this.numeroIdentifacion = numeroIdentifacion;
    }
    
    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        this.edad = getEdad();
        
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    

    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
		// TODO Auto-generated method stub
		this.contrasena = contrasena;
		
	}
    
    public void setEdad(int edad) {
		// TODO Auto-generated method stub
		this.edad = edad;
		
	}

   
    public int getEdad() {
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

	

  

}
