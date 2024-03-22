package com.api.food.foodapi.controller;

import com.api.food.foodapi.dto.FoodRequestDTO;
import com.api.food.foodapi.dto.FoodUpdateDTO;
import com.api.food.foodapi.service.FoodService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    FoodService service;


    @GetMapping
    public ResponseEntity getAll(){
        return service.serviceGetAllFoods();

    }

    @PostMapping
    @Transactional
    public ResponseEntity postFood(@RequestBody FoodRequestDTO data, UriComponentsBuilder uriBuilder){
        return service.serviceSaveFood(data, uriBuilder);

    }

    @PutMapping
    @Transactional
    public ResponseEntity putFood(@RequestBody FoodUpdateDTO data){
        return service.serviceUpdateFood(data);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteFood(@PathVariable String id){
        return service.serviceDeleteFood(id);

    }



    //GETS ESPECIFICOS
    @GetMapping("/id/{id}")
    public ResponseEntity getById(@PathVariable String id){
        return service.serviceGetById(id);

    }

    @GetMapping("/name/{nome}")
    public ResponseEntity getByNome(@PathVariable String nome){
        return service.serviceGetByNome(nome);

    }
}
