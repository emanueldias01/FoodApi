package com.api.food.foodapi.exception;

public class CamposIncompletosException extends RuntimeException{

    private final String lancamento = "Preencha os campos corretamente";

    public String getLancamento() {
        return lancamento;
    }

    public CamposIncompletosException(String message) {
        super(message);
    }
}
