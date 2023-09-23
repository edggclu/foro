package com.alura.infra.errores;

public class CamposInvalidos extends RuntimeException{
    public CamposInvalidos(String s){
        super(s);
    }
}
