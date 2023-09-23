package com.alura.domain.services;

import com.alura.domain.respuesta.*;
import com.alura.domain.topico.TopicoRepository;
import com.alura.domain.usuario.Usuario;
import com.alura.infra.errores.UsuarioNoPermitidoException;
import com.alura.infra.security.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RespuestaService {
    @Autowired
    TopicoRepository topicoRepository;
    @Autowired
    RespuestaRepository respuestaRepository;

    @Autowired
    SecurityFilter securityFilter;


    public DatosDetalleRespuesta responder(Long id, DatosResponderTopico datos) {
        var topicoRespondido = topicoRepository.getReferenceById(id);
        Usuario thisUsuario = securityFilter.getUser();
        var respuesta = new Respuesta(
                datos.mensaje(),
                topicoRespondido,
                LocalDateTime.now(),
                thisUsuario,
                false
        );
        topicoRespondido.updateStatus();
        topicoRepository.save(topicoRespondido);
        respuestaRepository.save(respuesta);
        return new DatosDetalleRespuesta(respuesta);
    }

    public void delete(Long id) {
        var respuesta = respuestaRepository.getReferenceById(id);
        Usuario thisUsuario = securityFilter.getUser();
        if(respuesta.getAutor()!=thisUsuario){
            throw new UsuarioNoPermitidoException("No tiene permitido borrar esta respuesta");
        }
        respuestaRepository.delete(respuesta);

    }

    public ActualizarDetalleRespuesta actualizar(Long id, DatosActualizarRespuesta datos) {
        Respuesta respuesta = respuestaRepository.getReferenceById(id);
        Usuario thisUsuario = securityFilter.getUser();
        if(respuesta.getAutor()!=thisUsuario){
            throw new UsuarioNoPermitidoException("No tiene permitido actualizar esta respuesta");
        }
        respuesta.setMensaje(datos.mensaje());
        return new ActualizarDetalleRespuesta(respuesta);
    }
}
