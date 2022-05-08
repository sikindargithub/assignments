package com.carapp.repository;

import com.carapp.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser,Integer> {

    // return the user by unique username
    AppUser findByUsername(String username);
}
