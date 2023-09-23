package com.alura.infra.errores;

public class PostExistenteException extends RuntimeException{
    public PostExistenteException(String s){
        super(s);
    }
}
