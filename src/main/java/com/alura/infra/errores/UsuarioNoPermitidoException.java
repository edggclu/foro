package com.alura.infra.errores;

public class UsuarioNoPermitidoException extends RuntimeException {
    public UsuarioNoPermitidoException(String s){
        super(s);
    }
}
