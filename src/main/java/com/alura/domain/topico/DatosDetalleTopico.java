package com.alura.domain.topico;

import com.alura.domain.curso.Curso;
import com.alura.domain.curso.DatosDetalleCurso;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime fecha,
        StatusTopico statusTopico, String autor, DatosDetalleCurso datos_del_curso) {

    public DatosDetalleTopico(Topico topico, Curso curso) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(), topico.getAutor().getNombre(), new DatosDetalleCurso(curso.getNombre(), curso.getCategoria()));
    }
}
