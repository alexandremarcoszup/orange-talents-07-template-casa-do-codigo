package br.com.orangetalents.cadadocodigo.domain.entity;

import br.com.orangetalents.cadadocodigo.controller.response.EstadoResponse;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nome;

    @ManyToOne
    private Pais pais;

    public Estado() {
    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public EstadoResponse domainToResponse() {
        return new EstadoResponse(this.id, this.nome, this.pais.domainToResponse());
    }

    public boolean verificaPais(Pais pais) {
        return this.pais.getId().equals(pais.getId());
    }
}
