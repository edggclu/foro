package com.alura.domain.curso;

public record DatosDetalleCurso(String nombre, String categoria) {
    public DatosDetalleCurso(Curso curso) {
        this(curso.getNombre(), curso.getCategoria());
    }
}
