package com.alura.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosNuevoCurso(
        Long id,

        @NotNull
        @NotBlank
        String nombre,

        @NotNull
        @NotBlank
        String categoria) {
}
