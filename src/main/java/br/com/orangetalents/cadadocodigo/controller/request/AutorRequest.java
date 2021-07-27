package br.com.orangetalents.cadadocodigo.controller.request;

import br.com.orangetalents.cadadocodigo.domain.entity.Autor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public class AutorRequest {

    @NotBlank
    private String nome;

    @NotEmpty @Email
    private String email;

    @NotEmpty @Length(max = 400)
    private String descricao;

    public AutorRequest(){}

    public Autor RequestToEntity() {
        return new Autor(this.nome, this.email, this.descricao, LocalDateTime.now());
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmail() {
        return this.email;
    }
}
