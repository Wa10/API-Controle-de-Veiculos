package com.desafio.controledeveiculos.controleveiculos.exceptions;

import java.util.Arrays;
import java.util.List;

public class Exceptions {

    private List<String> errors;

    public List<String> getErrors() {
        return errors;
    }

    public Exceptions(List<String> errors){
            this.errors = errors;
    }

    public Exceptions(String message){
            this.errors = Arrays.asList(message);
    }
}
