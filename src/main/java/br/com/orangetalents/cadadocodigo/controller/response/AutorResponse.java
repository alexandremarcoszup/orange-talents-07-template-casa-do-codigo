package br.com.orangetalents.cadadocodigo.controller.response;

import java.time.LocalDateTime;

public class AutorResponse {

    private Long id;

    private String nome;

    private String email;

    private String descricao;

    private LocalDateTime dataRegistro;

    public AutorResponse(Long id, String nome, String email, String descricao, LocalDateTime dataRegistro){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataRegistro = dataRegistro;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
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
