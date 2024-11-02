package com.example.prueba.controller;

import com.example.prueba.dto.ResponseDTO;
import com.example.prueba.dto.TransaccionDTO;
import com.example.prueba.model.BuyModel;
import com.example.prueba.repository.AuthRepository;
import com.example.prueba.repository.BuyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class Transaccion {
    final String CREDITO = "C";


    private BuyRepository buyRepository;
    private AuthRepository authRepository;

    public Transaccion() {
    }

    @PostMapping("/Transaccion")
    private ResponseEntity<ResponseDTO> Transaccion(TransaccionDTO transaccionDTO) {
        try{

             long saldo = authRepository.findByDocumento(transaccionDTO.getDocumento()).getSaldo();

             if(saldo < transaccionDTO.getValor()){
                 throw new Exception("Saldo insuficiente");
             }

             authRepository.actualizarSaldo(transaccionDTO.getDocumento(), saldo- transaccionDTO.getValor());

            BuyModel buyModel = new BuyModel(
                    transaccionDTO.getDocumento() ,
                    CREDITO,
                    transaccionDTO.getValor(),
                    transaccionDTO.getDestino(),
                    transaccionDTO.getTelefono()
            );

            buyRepository.save(buyModel);


            return ResponseEntity.ok(
                    new ResponseDTO(true, "Transferencia realizada con éxito")
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().body( new ResponseDTO(false, e.getMessage()));
        }
    }

}
