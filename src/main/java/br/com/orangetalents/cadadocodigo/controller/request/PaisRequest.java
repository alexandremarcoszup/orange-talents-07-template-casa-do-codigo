package br.com.orangetalents.cadadocodigo.controller.request;

import br.com.orangetalents.cadadocodigo.domain.entity.Pais;
import br.com.orangetalents.cadadocodigo.security.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public PaisRequest(){}

    public PaisRequest(@NotBlank String nome){
        this.nome = nome;
    }

    public Pais requestToDomain(){
        return new Pais(this.nome);
    }

    public void setNome( String nome) {
        this.nome = nome;
    }
}
