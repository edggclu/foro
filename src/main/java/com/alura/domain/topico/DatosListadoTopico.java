package com.alura.domain.topico;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DatosListadoTopico(Long id, String titulo, String mensaje,
                                 @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                 LocalDateTime fechaDeCreacion,
                                 String status, String autor, String curso, int respuestas) {

    public DatosListadoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus().toString(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre(),
                topico.getRespuestas().size());
    }
}
