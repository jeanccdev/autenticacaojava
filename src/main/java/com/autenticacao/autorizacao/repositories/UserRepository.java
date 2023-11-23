package com.autenticacao.autorizacao.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autenticacao.autorizacao.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    public User findUserByEmail(String email);
}