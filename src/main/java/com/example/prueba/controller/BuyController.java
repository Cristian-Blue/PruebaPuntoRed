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
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/buy")
public class BuyController {

    @Autowired
    private PuntoRedApiService puntoRedApiService;

    private final BuyRepository buyRepository;

    public BuyController(BuyRepository buyRepository) {
        this.buyRepository = buyRepository;
    }

    @PostMapping
    private ResponseEntity<ResponseDTO> buy (@Valid @RequestBody BuyParamDTO buyParamDTO) {
        try{
            BuyDTO buy =  puntoRedApiService.postBuy(buyParamDTO) ;
            System.out.println("12");
            System.out.println(buy);


            BuyModel buyModel = new BuyModel(
                    buy.getTransactionalID(),
                    buyParamDTO.getUser(),
                    Long.parseLong(buy.getValue()),
                    buy.getCellPhone()
            );
            buyRepository.save(buyModel);
            ResponseDTO result = new ResponseDTO(true ,buy);
            return ResponseEntity.ok(result) ;

        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body( new ResponseDTO(false, "Autenticación fallida", e.getMessage()));
        }
    }



}
