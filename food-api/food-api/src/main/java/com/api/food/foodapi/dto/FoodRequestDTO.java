package com.api.food.foodapi.dto;

import com.api.food.foodapi.model.Categoria;

public record FoodRequestDTO(String nome, Categoria categoria,String descricao, int calorias, double preco) {
}
