package br.com.orangetalents.cadadocodigo.controller;

import br.com.orangetalents.cadadocodigo.controller.request.PaisRequest;
import br.com.orangetalents.cadadocodigo.controller.response.PaisResponse;
import br.com.orangetalents.cadadocodigo.domain.entity.Pais;
import br.com.orangetalents.cadadocodigo.domain.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisRepository repository;

    @PostMapping
    public ResponseEntity<PaisResponse> cadastroPais(@RequestBody @Valid PaisRequest paisRequest){

        Pais pais = repository.save(paisRequest.requestToDomain());

        return ResponseEntity.ok(pais.domainToResponse());
    }
}
