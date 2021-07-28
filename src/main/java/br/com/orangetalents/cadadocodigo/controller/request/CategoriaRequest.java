package br.com.orangetalents.cadadocodigo.controller.request;

import br.com.orangetalents.cadadocodigo.domain.entity.Categoria;
import br.com.orangetalents.cadadocodigo.security.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public CategoriaRequest(){}

    public Categoria requestToEntity(){
        return new Categoria(this.nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }
}
