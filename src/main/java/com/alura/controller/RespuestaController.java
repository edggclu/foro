package com.alura.controller;

import com.alura.domain.respuesta.DatosResponderTopico;
import com.alura.domain.respuesta.RespuestaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/responder")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {
    @Autowired
    RespuestaService service;

    @PostMapping("/{id}")
    public ResponseEntity responderTopico(@PathVariable Long id, @RequestBody @Valid DatosResponderTopico datos) {
        var response = service.responder(id, datos);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
         service.delete(id);
         return ResponseEntity.noContent().build();
    }
}
