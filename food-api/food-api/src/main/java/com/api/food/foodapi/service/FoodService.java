package com.api.food.foodapi.service;

import com.api.food.foodapi.dto.FoodRequestDTO;
import com.api.food.foodapi.dto.FoodResponseDTO;
import com.api.food.foodapi.dto.FoodUpdateDTO;
import com.api.food.foodapi.exception.CamposIncompletosException;
import com.api.food.foodapi.exception.CamposNulosException;
import com.api.food.foodapi.exception.NotFoundException;
import com.api.food.foodapi.model.Categoria;
import com.api.food.foodapi.model.Food;
import com.api.food.foodapi.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    FoodRepository repository;

    //void methods security
    public void verificaCamposNulos(@RequestBody FoodRequestDTO data){
        if(data.nome() == null || data.categoria() == null || data.calorias() == 0 || data.descricao() == null || data.preco() == 0){
            throw new CamposNulosException("Campos nulos");
        }

    }

    public void validaCampos(@RequestBody FoodRequestDTO data){
        if(data.nome().length() < 8 || data.nome().length() > 50 || data.descricao().length() < 20 || data.descricao().length() > 250){

            throw new CamposIncompletosException("Campos incompletos");

        }

    }


    public ResponseEntity serviceGetAllFoods(){
        List<FoodResponseDTO> list = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return ResponseEntity.ok(list);
    }

    public ResponseEntity serviceSaveFood(@RequestBody FoodRequestDTO data, UriComponentsBuilder uriBuilder){
        verificaCamposNulos(data);
        validaCampos(data);
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

    public ResponseEntity serviceGetById(@PathVariable String id){

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("item não encontrado"));
    }

    public ResponseEntity serviceGetByNome(@PathVariable String nome){
        return ResponseEntity.ok(repository.findByNome(nome));

    }

    public ResponseEntity serviceListCategory(@PathVariable Categoria categoria){
        List<Food> list = repository.findByCategoria(categoria);
        return ResponseEntity.ok(list);

    }
}
