package br.com.orangetalents.cadadocodigo.controller.response;

public class PaisResponse {

    private Long id;

    private String nome;

    public PaisResponse(Long id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}