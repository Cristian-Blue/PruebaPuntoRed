package com.example.prueba.controller;

import com.example.prueba.dto.ResponseDTO;
import com.example.prueba.dto.SuppliersDTO;
import com.example.prueba.service.PuntoRedApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api")
public class SuppliersController {

    private PuntoRedApiService puntoRedService ;

    @GetMapping("/suppliers")
    public ResponseEntity<ResponseDTO> getSupplier() {
        try{
            return ResponseEntity.ok(new ResponseDTO(true, puntoRedService.getSuppliers()));
        }catch (Exception e){
            return ResponseEntity.badRequest().body( new ResponseDTO(false, "Autenticación fallida"));

        }


    }

}
