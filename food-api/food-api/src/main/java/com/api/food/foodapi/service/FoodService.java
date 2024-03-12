package com.api.food.foodapi.service;

import com.api.food.foodapi.dto.FoodRequestDTO;
import com.api.food.foodapi.dto.FoodResponseDTO;
import com.api.food.foodapi.dto.FoodUpdateDTO;
import com.api.food.foodapi.model.Food;
import com.api.food.foodapi.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    FoodRepository repository;

    public ResponseEntity serviceGetAllFoods(){
        List<FoodResponseDTO> list = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return ResponseEntity.ok(list);
    }

    public ResponseEntity serviceSaveFood(@RequestBody FoodRequestDTO data, UriComponentsBuilder uriBuilder){
        Food foodSave = new Food(data);
        repository.save(foodSave);
        var uri = uriBuilder.path("{id}").buildAndExpand(foodSave.getId()).toUri();
        var dto = new FoodResponseDTO(foodSave);
        return ResponseEntity.created(uri).body(dto);
    }

    public ResponseEntity serviceUpdateFood(@RequestBody FoodUpdateDTO data){
        var foodUpdate = repository.getReferenceById(data.id());
        foodUpdate.updateInfo(data);
        var dto = new FoodResponseDTO(foodUpdate);
        return ResponseEntity.ok(dto);
    }

    public ResponseEntity serviceDeleteFood(@PathVariable String id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
