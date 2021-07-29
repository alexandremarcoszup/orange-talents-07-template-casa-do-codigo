package br.com.orangetalents.cadadocodigo.controller.response;

import br.com.orangetalents.cadadocodigo.domain.entity.Livro;
import org.springframework.data.domain.Page;

public class LivroSimplesResponse {

    private Long id;

    private String nome;

    public LivroSimplesResponse(Long id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static Page<LivroSimplesResponse> convertToSimpleResponsePage(Page<Livro> livros){
        return livros.map(Livro::domainToSimpleReponse);
    }
}
