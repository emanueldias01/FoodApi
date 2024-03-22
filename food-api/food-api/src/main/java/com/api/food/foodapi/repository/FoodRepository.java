package com.api.food.foodapi.repository;

import com.api.food.foodapi.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, String> {
    public Food findByNome(String nome);
}
