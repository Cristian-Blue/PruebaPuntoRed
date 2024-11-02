package com.example.prueba.controller;

import com.example.prueba.dto.BuyDTO;
import com.example.prueba.dto.BuyParamDTO;
import com.example.prueba.dto.ResponseDTO;
import com.example.prueba.model.AuthModel;
import com.example.prueba.model.BuyModel;
import com.example.prueba.repository.AuthRepository;
import com.example.prueba.repository.BuyRepository;
import com.example.prueba.service.PuntoRedApiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class BuyController {

    final String DEBITO = "D";
    private PuntoRedApiService puntoRedApiService;

    @Autowired
    private BuyRepository buyRepository;

    private AuthRepository authRepository;

    @PostMapping("/buy")
    private ResponseEntity<ResponseDTO> buy (@Valid @RequestBody BuyParamDTO buyParamDTO) {
        try{
            puntoRedApiService = new PuntoRedApiService();
            ResponseDTO result = new ResponseDTO(true ,puntoRedApiService.postBuy(buyParamDTO));
            BuyModel buyModel = new BuyModel(
                    buyParamDTO.getDocumento(),
                    DEBITO,
                    buyParamDTO.getValue(),
                    buyParamDTO.getCellPhone(),
                    buyParamDTO.getSupplierId()
            );
            buyRepository.save(buyModel);
            long saldo = authRepository.findByDocumento(buyParamDTO.getDocumento()).getSaldo();
            authRepository.actualizarSaldo(buyParamDTO.getDocumento() , saldo  + buyParamDTO.getValue());


            return ResponseEntity.ok(result) ;

        }catch (Exception e){
            return ResponseEntity.badRequest().body( new ResponseDTO(false, "Autenticación fallida"));
        }
    }



}
