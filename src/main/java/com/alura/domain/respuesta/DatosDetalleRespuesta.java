package com.alura.domain.respuesta;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DatosDetalleRespuesta(
        Long idTopico,
        String topico,
        String nombre_del_curso,
        String mensaje,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime fechaCreacion,
        String autor,
        Long idRespuesta,
        String solucion) {

    public DatosDetalleRespuesta(Respuesta respuesta) {
        this(
                respuesta.getTopico().getId(),
                respuesta.getTopico().getTitulo(),
                respuesta.getTopico().getCurso().getNombre(),
                respuesta.getMensaje(),
                respuesta.getFecha_de_creacion(),
                respuesta.getAutor().getNombre(),
                respuesta.getId(),
                respuesta.getSolucion().toString()
        );

    }
}
