package br.com.orangetalents.cadadocodigo.controller.response;

public class EstadoResponse {

    private Long id;

    private String nome;

    private PaisResponse pais;

    public EstadoResponse(Long id, String nome, PaisResponse pais){
        this.id = id;
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public PaisResponse getPais() {
        return pais;
    }
}
