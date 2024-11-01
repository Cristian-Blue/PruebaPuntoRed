package com.example.prueba.dto;

import jakarta.validation.constraints.NotBlank;

public class AuthDTO {


    public AuthDTO(){}
    public AuthDTO(String user, String password){
        this.user = user;
        this.password = password;
    }


    @NotBlank(message = "El usuario no puede estar vacio")
    String user;
    @NotBlank(message = "Password requerido")
    String password;

    public String getUser() {return user;}
    public void setUser(String user) {this.user = user;}

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }




}
