package com.api.food.foodapi.model;

import com.api.food.foodapi.dto.FoodRequestDTO;
import com.api.food.foodapi.dto.FoodUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tab_food")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private Categoria categoria;
    private int calorias;
    private double preco;

    public Food(FoodRequestDTO data) {
        this.nome = data.nome();
        this.categoria = data.categoria();
        this.calorias = data.calorias();
        this.preco = data.preco();
    }

    public void updateInfo(FoodUpdateDTO data) {
        if(data.nome() != null){
            this.nome = data.nome();
        }

        if(data.calorias() != 0){
            this.calorias = data.calorias();
        }

        if(data.preco() != 0){
            this.preco = data.preco();
        }
    }
}
