package com.autenticacao.autorizacao.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autenticacao.autorizacao.models.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    
}