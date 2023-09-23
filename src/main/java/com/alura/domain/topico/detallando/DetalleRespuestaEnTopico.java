package com.alura.domain.topico.detallando;

import com.alura.domain.respuesta.Respuesta;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DetalleRespuestaEnTopico(
        Long id, String mensaje,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime fecha_de_comentario,
        String autor,
        String util) {
    public DetalleRespuestaEnTopico(Respuesta respuesta) {
        this(respuesta.getId(), respuesta.getMensaje(), respuesta.getFecha_de_creacion(), respuesta.getAutor().getNombre(),respuesta.getSolucion().toString());
    }
}
