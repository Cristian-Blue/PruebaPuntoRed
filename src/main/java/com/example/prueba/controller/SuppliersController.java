package com.example.prueba.controller;

import com.example.prueba.dto.ResponseDTO;
import com.example.prueba.dto.SuppliersDTO;
import com.example.prueba.service.PuntoRedApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SuppliersController {

    private PuntoRedApiService puntoRedService ;
    public ResponseEntity<ResponseDTO> getSupplier() {
        try{

            List<SuppliersDTO> list =  puntoRedService.getSuppliers();
            return ResponseEntity.ok(new ResponseDTO(true, list));
        }catch (Exception e){
            return ResponseEntity.badRequest().body( new ResponseDTO(false, "Autenticación fallida"));

        }


    }

}
