package com.example.prueba.controller;

import com.example.prueba.dto.AuthDTO;
import com.example.prueba.dto.ResponseDTO;
import com.example.prueba.dto.TokenDTO;
import com.example.prueba.repository.AuthRepository;
import com.example.prueba.service.PuntoRedApiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private PuntoRedApiService puntoRedApiService;

    @PostMapping(value = "/auth")
    public ResponseEntity<ResponseDTO> auth(@Valid @RequestBody AuthDTO authModel) {
        try{
            TokenDTO token = this.puntoRedApiService.auth(authModel.getUser(), authModel.getPassword());
            return ResponseEntity.ok(new ResponseDTO(true, token));
        }catch (Exception e){
            return ResponseEntity.badRequest().body( new ResponseDTO(false, "Autenticación fallida"));
        }

    }
}
