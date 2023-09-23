package com.alura.domain.topico.validacion;

import com.alura.domain.respuesta.Respuesta;
import com.alura.domain.topico.StatusTopico;
import com.alura.domain.topico.Topico;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidadorRespondido {

    public void validar(Topico topicoRespondido) {
        var respuestas = topicoRespondido.getRespuestas();
        if (respuestas.isEmpty()) {
            topicoRespondido.setStatus(StatusTopico.NO_RESPONDIDO);
        }
        if (!respuestas.isEmpty()) {
            topicoRespondido.setStatus(StatusTopico.NO_SOLUCIONADO);
        }

        for (Respuesta respuesta : respuestas) {
            if (respuesta.getSolucion()) {
                topicoRespondido.setStatus(StatusTopico.SOLUCIONADO);
            }
        }
    }
}
