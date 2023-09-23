package com.alura.domain.usuario;

public record DatosDetalleUsuario(Long id, String nombre, String correo, String password) {
    public DatosDetalleUsuario(Usuario usuario, String oldpassword){
        this(usuario.getId(), usuario.getNombre(), usuario.getEmail(), oldpassword);
    }
}
