package br.com.orangetalents.cadadocodigo.controller;

import br.com.orangetalents.cadadocodigo.controller.request.LivroRequest;
import br.com.orangetalents.cadadocodigo.controller.response.LivroResponse;
import br.com.orangetalents.cadadocodigo.domain.entity.Livro;
import br.com.orangetalents.cadadocodigo.domain.repository.AutorRepository;
import br.com.orangetalents.cadadocodigo.domain.repository.CategoriaRepository;
import br.com.orangetalents.cadadocodigo.domain.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<LivroResponse> cadastraLivro(@RequestBody @Valid LivroRequest livroRequest){

        Livro livro = livroRepository.save(livroRequest.requestToDomain(autorRepository, categoriaRepository));

        return ResponseEntity.ok(livro.domainToResponse());
    }
}
