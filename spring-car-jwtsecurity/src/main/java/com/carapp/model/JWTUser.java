package com.carapp.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JWTUser {

    @Column(unique = true,length = 30)
    private String username;
    private String password;
    @Id
    @GeneratedValue
    private Integer userId;

    public JWTUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
