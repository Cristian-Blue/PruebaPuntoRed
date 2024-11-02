package com.example.prueba.repository;
import com.example.prueba.model.AuthModel;
import com.example.prueba.model.BuyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface BuyRepository extends  JpaRepository<BuyModel , Long> { }
