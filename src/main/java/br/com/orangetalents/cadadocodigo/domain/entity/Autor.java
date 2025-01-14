package br.com.orangetalents.cadadocodigo.domain.entity;

import br.com.orangetalents.cadadocodigo.controller.response.AutorDetalhesResponse;
import br.com.orangetalents.cadadocodigo.controller.response.AutorResponse;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank @Email
    private String email;

    @NotBlank
    private String descricao;


    private LocalDateTime dataRegistro;

    public Autor(){}

    public Autor(String nome, String email, String descricao, LocalDateTime dataRegistro){
        this.nome = nome;
        this.descricao = descricao;
        this.email = email;
        this.dataRegistro = dataRegistro;
    }

    public AutorResponse domainToResponse(){
        return new AutorResponse(this.id, this.nome, this.email, this.descricao, this.dataRegistro);
    }

    public AutorDetalhesResponse domainToDetalhesResponse(){
        return new AutorDetalhesResponse(this.nome,this.descricao);
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }
}
