package com.example.prueba.controller;

import com.example.prueba.dto.AuthDTO;
import com.example.prueba.model.AuthModel;
import com.example.prueba.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private AuthRepository authRepository;

    @PostMapping("/auth")
    public List<AuthModel> auth(@RequestBody AuthDTO authModel) {


        return authRepository.findByTelefonoAndPassword(authModel.getTelefono() , authModel.getPassword());
    }
}
