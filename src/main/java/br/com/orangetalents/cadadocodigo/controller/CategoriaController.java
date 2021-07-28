package br.com.orangetalents.cadadocodigo.controller;

import br.com.orangetalents.cadadocodigo.controller.request.CategoriaRequest;
import br.com.orangetalents.cadadocodigo.controller.response.CategoriaResponse;
import br.com.orangetalents.cadadocodigo.domain.entity.Categoria;
import br.com.orangetalents.cadadocodigo.domain.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<CategoriaResponse> criarNovaCategoria(@RequestBody @Valid CategoriaRequest categoriaRequest){

        Categoria categoria = categoriaRepository.save(categoriaRequest.requestToEntity());

        return ResponseEntity.ok(categoria.domainToResponse());
    }
}
