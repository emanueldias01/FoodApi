package com.api.food.foodapi.dto;

import com.api.food.foodapi.model.Categoria;
import com.api.food.foodapi.model.Food;

public record FoodResponseDTO(String id, String nome, Categoria categoria, int calorias, double preco) {

    public FoodResponseDTO(Food food){
        this(food.getId(), food.getNome(), food.getCategoria(), food.getCalorias(), food.getPreco());

    }
}
