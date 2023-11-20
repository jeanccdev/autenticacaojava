package com.autenticacao.autorizacao.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autenticacao.autorizacao.models.Food;

public interface FoodRepository extends JpaRepository<Food, UUID> {

}