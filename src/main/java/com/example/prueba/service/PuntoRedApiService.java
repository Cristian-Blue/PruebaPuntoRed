package com.example.prueba.service;

import com.example.prueba.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PuntoRedApiService {

    @Value("${puntored.api.end-pont}")
    private String endPoint;

    @Value("${puntored.x.api.key}")
    private String apiKey;


    public HttpEntity<Object> prepareData(Object data) {
        HttpHeaders headers =  new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", this.apiKey);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof String) {
            System.out.println(auth.getPrincipal());
            headers.set("Authorization", "Bearer " +  (String) auth.getPrincipal());
        }
        return new HttpEntity<>(data, headers);
    }

    public TokenDTO auth(String user, String password) {
        try{
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.postForObject(endPoint + "/auth",  this.prepareData(new AuthDTO(user, password)), TokenDTO.class);
        }catch (Exception $e){
            throw new RuntimeException("Autorización fallida " + $e.getMessage());
        }

    }


    public List<SuppliersDTO> getSuppliers () {
        try{
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<List<SuppliersDTO>> list = restTemplate.exchange(
                    endPoint + "/getSuppliers",
                    HttpMethod.GET,
                    this.prepareData(null),
                    new ParameterizedTypeReference<List<SuppliersDTO>>() {});

            return list.getBody();
        }catch (Exception $e){
            throw new RuntimeException($e.getMessage());
        }
    }


    public BuyDTO postBuy(BuyParamDTO buyParam) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            BuySendDTO data =  new BuySendDTO(
                buyParam.getCellPhone(),
                buyParam.getValue(),
                buyParam.getSupplierId()
            );
            return restTemplate.postForObject(
                    endPoint + "/buy",
                    this.prepareData( data),
                    BuyDTO.class);

        }catch (Exception $e){
            throw new RuntimeException($e.getMessage());
        }
    }


}
