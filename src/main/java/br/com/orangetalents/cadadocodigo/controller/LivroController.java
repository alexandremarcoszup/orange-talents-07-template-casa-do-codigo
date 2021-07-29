package br.com.orangetalents.cadadocodigo.controller;

import br.com.orangetalents.cadadocodigo.controller.request.LivroRequest;
import br.com.orangetalents.cadadocodigo.controller.response.LivroDetalhesResponse;
import br.com.orangetalents.cadadocodigo.controller.response.LivroResponse;
import br.com.orangetalents.cadadocodigo.controller.response.LivroSimplesResponse;
import br.com.orangetalents.cadadocodigo.domain.entity.Livro;
import br.com.orangetalents.cadadocodigo.domain.repository.AutorRepository;
import br.com.orangetalents.cadadocodigo.domain.repository.CategoriaRepository;
import br.com.orangetalents.cadadocodigo.domain.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Optional;

import static br.com.orangetalents.cadadocodigo.controller.response.LivroSimplesResponse.convertToSimpleResponsePage;

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
    public ResponseEntity<LivroResponse> cadastraLivro(@RequestBody @Valid LivroRequest livroRequest) {

        Livro livro = livroRepository.save(livroRequest.requestToDomain(autorRepository, categoriaRepository));

        return ResponseEntity.ok(livro.domainToResponse());
    }

    @GetMapping("/todos")
    public ResponseEntity<Page<LivroSimplesResponse>> listaLivros(@PageableDefault Pageable pageable) {
        Page<Livro> livros = livroRepository.findAll(pageable);

        return ResponseEntity.ok(convertToSimpleResponsePage(livros));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDetalhesResponse> detalharLivro(@PathVariable("id") Long id) {

        Optional<Livro> livro = livroRepository.findById(id);

        return livro.map(value -> ResponseEntity.ok(value.domainToDetalhesResponse()))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }
}
