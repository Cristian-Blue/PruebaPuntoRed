package com.example.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PuntoRedApiService {

    private RestTemplate restTemplate;

    @Value("${puntored.api.end-pont}")
    private String endPoint;

    @Value("${puntored.x.api.key}")
    private String apiKey;





}
