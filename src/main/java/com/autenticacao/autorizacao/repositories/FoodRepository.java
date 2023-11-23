package com.autenticacao.autorizacao.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autenticacao.autorizacao.models.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, UUID> {

}