package com.example.prueba.controller;

import com.example.prueba.dto.ResponseDTO;
import com.example.prueba.repository.BuyRepository;
import com.example.prueba.service.PuntoRedApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/api/report")
public class ReportController {

    private final BuyRepository buyRepository;

    public ReportController(BuyRepository buyRepository) {
        this.buyRepository = buyRepository;
    }


    @GetMapping
    public ResponseEntity<ResponseDTO> getReport() {
        try{
            return ResponseEntity.ok(new ResponseDTO(true, buyRepository.findAll()));
        }catch (Exception e){
            return ResponseEntity.badRequest().body( new ResponseDTO(false, "Autenticación fallida", e.getMessage()));

        }
    }

}
