package com.example.filmback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long id;

    @Column(name = "username",nullable = false,unique = true)
    String username;
    @Column(name = "email",nullable = false,unique = true)
    String email;
    @Column(name = "password",nullable = false)
    String password;



}
