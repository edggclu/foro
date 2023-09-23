package com.alura.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRespuestaComoSolucion(
        @NotNull
        Boolean solucion
) {
}
