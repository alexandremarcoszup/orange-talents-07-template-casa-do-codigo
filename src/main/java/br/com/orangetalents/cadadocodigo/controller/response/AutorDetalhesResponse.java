package br.com.orangetalents.cadadocodigo.controller.response;

public class AutorDetalhesResponse {

    private String nome;

    private String descricao;

    public AutorDetalhesResponse(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
