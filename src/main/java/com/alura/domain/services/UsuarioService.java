package com.alura.domain.services;

import com.alura.domain.usuario.DatosDetalleUsuario;
import com.alura.domain.usuario.DatosRegistroUsuario;
import com.alura.domain.usuario.Usuario;
import com.alura.domain.usuario.UsuarioRepository;
import com.alura.infra.errores.UsuarioNoPermitidoException;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public DatosDetalleUsuario registrar(DatosRegistroUsuario datos) {
        var nombreOcupado = repository.findByNombre(datos.nombre());
        var correoOcupado = repository.findByEmail(datos.email());
        if (nombreOcupado != null) {
            throw new UsuarioNoPermitidoException("Este nombre de usuario ya esta ocupado");
        }
        if (correoOcupado != null) {
            throw new UsuarioNoPermitidoException("Ya existe una cuenta vinculada a este correo");
        }
        if (!datos.password().equals(datos.confirm_password())){
            throw new UsuarioNoPermitidoException("Las contraseñas no coinciden");
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
        String password = bCryptPasswordEncoder.encode(datos.password());
        Usuario usuario = new Usuario(datos.nombre(), datos.email(), password);
        repository.save(usuario);
        return new DatosDetalleUsuario(usuario, datos.password());
    }
}
