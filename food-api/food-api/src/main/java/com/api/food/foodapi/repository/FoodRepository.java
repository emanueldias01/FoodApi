package com.api.food.foodapi.repository;

import com.api.food.foodapi.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, String> {
}
