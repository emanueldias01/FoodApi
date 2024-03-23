package com.api.food.foodapi.exception.handler;

import com.api.food.foodapi.exception.CamposIncompletosException;
import com.api.food.foodapi.exception.CamposNulosException;
import com.api.food.foodapi.exception.NotFoundException;
import com.api.food.foodapi.exception.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class handlerExc {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public ErrorDTO trataErroCamposNulos(CamposNulosException ex){
        return new ErrorDTO(
                ex.getMessage(),
                ex.getLancamento()

        );
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO trataValidacaoCampos(CamposIncompletosException ex){
        return new ErrorDTO(
                ex.getMessage(),
                ex.getLancamento()

        );

    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO trataErroNotFound(NotFoundException ex){
        return new ErrorDTO(

                ex.getMessage(),
                ex.getLancamento()

        );

    }
}
