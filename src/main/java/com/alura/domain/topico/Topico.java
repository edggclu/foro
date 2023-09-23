package com.alura.domain.topico;

import com.alura.domain.curso.Curso;
import com.alura.domain.respuesta.Respuesta;
import com.alura.domain.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;

    @Column(name = "fechaCreacion")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime fechaCreacion;

    private StatusTopico status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas = new ArrayList<>();

    public Topico(String titulo, String mensaje, Curso curso, LocalDateTime fecha, StatusTopico status, Usuario usuario) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.curso = curso;
        this.fechaCreacion = fecha;
        this.status = status;
        this.autor = usuario;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setfechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setStatus(StatusTopico status) {
        this.status = status;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public void updateStatus() {
        var respuestas = this.getRespuestas();
        if (respuestas.isEmpty()) {
            this.status = (StatusTopico.NO_RESPONDIDO);
        }
        if (!respuestas.isEmpty()) {
            this.status = (StatusTopico.NO_SOLUCIONADO);
        }
        for (Respuesta respuesta : respuestas) {
            if (respuesta.getSolucion()) {
                this.status = (StatusTopico.SOLUCIONADO);
                break;
            }
        }
    }

    public void actualizarDatos(DatosActualizarTopico datos) {
        if (datos.titulo() != null){
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null){
            this.mensaje = datos.mensaje();
        }
    }

}
