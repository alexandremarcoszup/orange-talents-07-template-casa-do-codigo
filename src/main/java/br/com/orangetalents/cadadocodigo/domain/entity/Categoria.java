package br.com.orangetalents.cadadocodigo.domain.entity;

import br.com.orangetalents.cadadocodigo.controller.response.CategoriaResponse;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    public Categoria(){}

    public Categoria(String nome){
        this.nome = nome;
    }

    public CategoriaResponse entityToResponse(){
        return new CategoriaResponse(this.id, this.nome);
    }
}
