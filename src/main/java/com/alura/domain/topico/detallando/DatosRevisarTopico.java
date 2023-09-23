package com.alura.domain.topico.detallando;

import com.alura.domain.curso.DatosDetalleCurso;
import com.alura.domain.topico.StatusTopico;
import com.alura.domain.topico.Topico;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public record DatosRevisarTopico(
        Long id,
        String titulo,
        String mensaje,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime fecha,
        StatusTopico statusTopico,
        DatosDetalleCurso datos_del_curso,
        Stream<DetalleRespuestaEnTopico> respuestas

) {

    public DatosRevisarTopico(Topico topico, Stream<DetalleRespuestaEnTopico> respuestas) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                new DatosDetalleCurso(topico.getCurso().getNombre(), topico.getCurso().getCategoria()),
                respuestas
        );
    }


}
