package com.api.food.foodapi.exception;

public class NotFoundException extends RuntimeException{
    private final String lancamento = "O item pesquisado não foi encontrado";

    public NotFoundException(String message) {
        super(message);
    }

    public String getLancamento() {
        return lancamento;
    }
}
