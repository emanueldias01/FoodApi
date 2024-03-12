package com.api.food.foodapi.dto;

public record FoodUpdateDTO(String id, String nome,String descricao, int calorias, double preco) {
}
