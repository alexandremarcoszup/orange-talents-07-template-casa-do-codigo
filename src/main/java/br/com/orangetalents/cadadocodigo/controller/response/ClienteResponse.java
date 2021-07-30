package br.com.orangetalents.cadadocodigo.controller.response;

public class ClienteResponse {

    private Long id;

    private String nome;

    private String email;

    private String sobrenome;

    private String documento;

    private String complemento;

    private String cidade;

    private PaisResponse pais;

    private EstadoResponse estado;

    private String telefone;

    private String cep;

    public ClienteResponse(Long id, String nome, String email, String sobrenome, String documento, String complemento, String cidade, PaisResponse pais, EstadoResponse estado, String telefone, String cep) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public PaisResponse getPais() {
        return pais;
    }

    public EstadoResponse getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
