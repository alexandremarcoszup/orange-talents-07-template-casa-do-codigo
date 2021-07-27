package br.com.orangetalents.cadadocodigo.controller;

import br.com.orangetalents.cadadocodigo.controller.request.CategoriaRequest;
import br.com.orangetalents.cadadocodigo.controller.response.CategoriaResponse;
import br.com.orangetalents.cadadocodigo.domain.entity.Categoria;
import br.com.orangetalents.cadadocodigo.domain.repository.CategoriaRepository;
import br.com.orangetalents.cadadocodigo.security.validator.ValidadorNomeDuplicadoCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ValidadorNomeDuplicadoCategoria validadorNomeDuplicadoCategoria;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(validadorNomeDuplicadoCategoria);
    }

    @PostMapping
    public ResponseEntity<CategoriaResponse> criarNovaCategoria(@RequestBody @Valid CategoriaRequest categoriaRequest){

        Categoria categoria = categoriaRepository.save(categoriaRequest.requestToEntity());

        return ResponseEntity.ok(categoria.entityToResponse());
    }
}
