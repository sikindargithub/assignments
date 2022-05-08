package com.carapp.repository;

import com.carapp.model.JWTUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JWTUserRepository extends JpaRepository<JWTUser,Integer> {

    JWTUser findByUsername(String username);
}
