package br.com.orangetalents.cadadocodigo.domain.entity;

import br.com.orangetalents.cadadocodigo.controller.response.PaisResponse;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Column(unique = true)
    private String nome;

    public Pais(){}

    public Pais(String nome){
        this.nome = nome;
    }

    public PaisResponse domainToResponse(){
        return new PaisResponse(this.id, this.nome);
    }
}
