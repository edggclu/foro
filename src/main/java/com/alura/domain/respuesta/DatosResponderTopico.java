package com.alura.domain.respuesta;

import jakarta.validation.constraints.NotNull;

public record DatosResponderTopico(
        @NotNull
        String mensaje) {
}
