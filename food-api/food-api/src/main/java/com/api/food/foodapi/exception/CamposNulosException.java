package com.api.food.foodapi.exception;

public class CamposNulosException extends RuntimeException{
    private final String lancamento = "Preencha todos os campos";

    public CamposNulosException(String message) {
        super(message);
    }

    public String getLancamento() {
        return lancamento;
    }
}
