package com.alura.domain.respuesta;

import com.alura.domain.topico.Topico;
import com.alura.domain.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String mensaje;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topico_id")
	private Topico topico;

	@Column(name = "fecha_de_creacion")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime fecha_de_creacion;


	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Usuario autor;

	private Boolean solucion;
	public Respuesta(String mensaje, Topico topico, LocalDateTime fecha_de_creacion, Usuario autor, Boolean solucion) {
		this.mensaje = mensaje;
		this.topico = topico;
		this.fecha_de_creacion = fecha_de_creacion;
		this.autor = autor;
		this.solucion = solucion;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Topico getTopico() {
		return topico;
	}

	public void setTopico(Topico topico) {
		this.topico = topico;
	}

	public LocalDateTime getFecha_de_creacion() {
		return fecha_de_creacion;
	}

	public void setfechaCreacion(LocalDateTime fechaCreacion) {
		this.fecha_de_creacion = fechaCreacion;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Boolean getSolucion() {
		return solucion;
	}

	public void setSolucion(Boolean solucion) {
		this.solucion = solucion;
	}

}
