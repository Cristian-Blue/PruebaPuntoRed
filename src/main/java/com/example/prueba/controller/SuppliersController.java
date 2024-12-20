package com.example.prueba.controller;

import com.example.prueba.dto.ResponseDTO;
import com.example.prueba.service.PuntoRedApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/api/suppliers")
public class SuppliersController {

    private final PuntoRedApiService puntoRedService ;

    public SuppliersController(PuntoRedApiService puntoRedService) {
        this.puntoRedService = puntoRedService;
    }


    @GetMapping
    public ResponseEntity<ResponseDTO> getSupplier() {
        try{
            return ResponseEntity.ok(new ResponseDTO(true, puntoRedService.getSuppliers()));
        }catch (Exception e){
            return ResponseEntity.badRequest().body( new ResponseDTO(false, "Autenticación fallida", e.getMessage()));

        }
    }

}
