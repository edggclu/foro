package com.alura.controller;

import com.alura.domain.services.TopicoService;
import com.alura.domain.topico.*;
import com.alura.domain.respuesta.RespuestaRepository;
import com.alura.respuesta.DatosRespuestaComoSolucion;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@ResponseBody
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {
    @Autowired
    TopicoService service;
    @Autowired
    TopicoRepository repository;
    @Autowired
    RespuestaRepository respuestaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity postearTopico(@RequestBody @Valid DatosPostearTopico datosPostearTopico) {
        var response = service.postear(datosPostearTopico);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Stream<DatosListadoTopico>> listarTopicos() {
        //var response = repository.findAll(paginacion).map(DatosListadoTopico::new);
        var topicos = repository.findAll();
        topicos.forEach(Topico::updateStatus);
        return ResponseEntity.ok(topicos.stream().map(DatosListadoTopico::new));

    }

    @GetMapping("/{id}")
    public ResponseEntity readTopico(@PathVariable Long id) {
        var response = service.ver(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datos) {
        var response = service.actualizar(id, datos);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopico(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idTopico}/respuesta/{respuestaId}")
    @Transactional
    public ResponseEntity setRespuestaComoSolucion(@PathVariable Long idTopico, @PathVariable Long respuestaId, @RequestBody @Valid DatosRespuestaComoSolucion datos) {
        service.setSolucion(idTopico, respuestaId, datos);
        return ResponseEntity.noContent().build();
    }

}
