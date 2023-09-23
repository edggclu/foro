package com.alura.domain.topico;

import com.alura.domain.curso.Curso;
import com.alura.domain.curso.DatosNuevoCurso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosPostearTopico(
        Long id,

        @NotNull
        @NotBlank
        String titulo,

        @NotNull
        @NotBlank
        String mensaje,

        @NotNull
        @Valid
        DatosNuevoCurso curso) {
}
