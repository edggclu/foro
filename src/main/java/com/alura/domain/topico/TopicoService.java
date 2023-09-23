package com.alura.domain.topico;

import com.alura.domain.curso.Curso;
import com.alura.domain.curso.CursoRepository;
import com.alura.domain.topico.detallando.DatosRevisarTopico;
import com.alura.domain.topico.detallando.DetalleRespuestaEnTopico;
import com.alura.domain.usuario.Usuario;
import com.alura.domain.usuario.UsuarioRepository;
import com.alura.infra.errores.UsuarioNoPermitidoException;
import com.alura.infra.security.SecurityFilter;
import com.alura.domain.respuesta.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopicoService {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    RespuestaRepository respuestaRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    SecurityFilter securityFilter;

    public DatosDetalleTopico postear(DatosPostearTopico datos) {
        if (topicoRepository.existsByTitulo(datos.titulo())) {
            throw new RuntimeException("Existe");
        }

        Usuario usuario = securityFilter.getUser();
        Curso curso = cursoRepository.getReferenceByNombreAndCategoria(datos.curso().nombre(),datos.curso().categoria());

        if(curso == null){
            curso = new Curso(datos.curso().nombre(), datos.curso().categoria());
            cursoRepository.save(curso);
        }

        var topico = new Topico(
                datos.titulo(),
                datos.mensaje(),
                curso,
                LocalDateTime.now(),
                StatusTopico.NO_RESPONDIDO,
                usuario);
        topicoRepository.save(topico);
        return new DatosDetalleTopico(topico, curso);
    }

    public DatosRevisarTopico ver(Long id) {
        Topico topicoEncontrado = topicoRepository.getReferenceById(id);
        topicoEncontrado.updateStatus();
        topicoRepository.save(topicoEncontrado);
        var respuestas = respuestaRepository.findAllByTopicoId(id).stream().map(DetalleRespuestaEnTopico::new);
        return new DatosRevisarTopico(topicoEncontrado, respuestas);
    }

    public DatosDetalleTopico actualizar(Long id, DatosActualizarTopico datos) {
        Usuario usuario = securityFilter.getUser();
        var topico = topicoRepository.getReferenceById(id);
        if (usuario != topico.getAutor()) {
            throw new UsuarioNoPermitidoException("No tiene permitido modificar este Topico");
        }
        topico.actualizarDatos(datos);
        return new DatosDetalleTopico(topico, topico.getCurso());
    }

    public void delete(Long id) {
        Usuario usuario = securityFilter.getUser();
        var topico = topicoRepository.getReferenceById(id);
        if (usuario != topico.getAutor()) {
            throw new UsuarioNoPermitidoException("No tiene permitido eliminar este topico");
        }
        topicoRepository.delete(topico);

    }
}
