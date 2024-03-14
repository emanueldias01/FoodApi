package com.api.food.foodapi.exception.dto;

public class ErrorDTO {

    private String mensagem;
    private String lancamento;

    public ErrorDTO(String mensagem, String lancamento) {
        this.mensagem = mensagem;
        this.lancamento = lancamento;
    }

    public String getLancamento() {
        return lancamento;
    }

    public String getMensagem() {
        return mensagem;
    }
}
