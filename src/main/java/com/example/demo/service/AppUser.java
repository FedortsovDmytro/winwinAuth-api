package com.example.demo.service;

import jakarta.persistence.EntityManager;

public class AppUser {
    private final EntityManager em;
    public AppUser(EntityManager em) {
        this.em = em;
    }

}