package br.com.orangetalents.cadadocodigo.controller;

import br.com.orangetalents.cadadocodigo.controller.request.EstadoRequest;
import br.com.orangetalents.cadadocodigo.controller.response.EstadoResponse;
import br.com.orangetalents.cadadocodigo.domain.entity.Estado;
import br.com.orangetalents.cadadocodigo.domain.repository.EstadoRepository;
import br.com.orangetalents.cadadocodigo.domain.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<EstadoResponse> cadastroEstado(@RequestBody @Valid EstadoRequest estadoRequest) {

        Estado estado = estadoRepository.save(estadoRequest.requestToDomain(paisRepository));

        return ResponseEntity.ok(estado.domainToResponse());
    }
}
