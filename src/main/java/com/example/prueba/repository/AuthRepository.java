package com.example.prueba.repository;

import com.example.prueba.model.AuthModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuthRepository extends JpaRepository<AuthModel, Long> {
    List<AuthModel> findByUsernameAndPassword(String user, String password);

}
