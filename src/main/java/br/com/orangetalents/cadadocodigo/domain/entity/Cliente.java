package br.com.orangetalents.cadadocodigo.domain.entity;


import br.com.orangetalents.cadadocodigo.controller.response.ClienteResponse;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @Column(unique = true)
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public Cliente() {
    }

    public Cliente(String nome, String email, String sobrenome, String documento, String endereco, String complemento,
                   String cidade, Pais pais, String telefone, String cep) {
        this.nome = nome;
        this.email = email;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public ClienteResponse domainToResponse(){
        return new ClienteResponse(this.id, this.nome, this.email, this.sobrenome, this.documento, this.complemento, this.cidade,
                this.pais.domainToResponse(), this.estado.domainToResponse(), this.telefone, this.cep);
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
