package com.example.prueba.controller;

import com.example.prueba.dto.BuyDTO;
import com.example.prueba.dto.BuyParamDTO;
import com.example.prueba.dto.ResponseDTO;
import com.example.prueba.model.AuthModel;
import com.example.prueba.service.PuntoRedApiService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class BuyController {


    private PuntoRedApiService puntoRedApiService;
    private

    @PostMapping("/buy")
    public ResponseEntity<ResponseDTO> buy (@Valid @RequestBody BuyParamDTO buyParamDTO) {
        try{
            puntoRedApiService = new PuntoRedApiService();
            BuyDTO buyDTO = new BuyDTO();


            return ResponseEntity.ok(new ResponseDTO(true ,puntoRedApiService.postBuy(buyParamDTO))
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body( new ResponseDTO(false, "Autenticación fallida"));
        }
    }



}
