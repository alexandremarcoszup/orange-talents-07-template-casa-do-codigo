package br.com.orangetalents.cadadocodigo.controller;

import br.com.orangetalents.cadadocodigo.controller.request.AutorRequest;
import br.com.orangetalents.cadadocodigo.controller.response.AutorResponse;
import br.com.orangetalents.cadadocodigo.domain.entity.Autor;
import br.com.orangetalents.cadadocodigo.domain.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<AutorResponse> cadastroAutor(@RequestBody @Valid AutorRequest autorRequest) {

        Autor autor = autorRepository.save(autorRequest.RequestToEntity());

        return ResponseEntity.ok(autor.domainToResponse());
    }
}
