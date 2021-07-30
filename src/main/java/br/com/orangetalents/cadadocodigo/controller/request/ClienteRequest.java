package br.com.orangetalents.cadadocodigo.controller.request;

import br.com.orangetalents.cadadocodigo.domain.entity.Cliente;
import br.com.orangetalents.cadadocodigo.domain.entity.Estado;
import br.com.orangetalents.cadadocodigo.domain.entity.Pais;
import br.com.orangetalents.cadadocodigo.domain.repository.EstadoRepository;
import br.com.orangetalents.cadadocodigo.domain.repository.PaisRepository;
import br.com.orangetalents.cadadocodigo.security.validator.ExistisId;
import org.springframework.util.Assert;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ClienteRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ExistisId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    private Long idEstado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public ClienteRequest(@NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento,
                          @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Long idPais,
                          Long idEstado, @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente requestToDomain(PaisRepository paisRepository, EstadoRepository estadoRepository) {

        Optional<Pais> pais = paisRepository.findById(this.idPais);

        Cliente cliente = new Cliente(this.nome, this.email, this.sobrenome, this.documento, this.endereco, this.complemento,
                this.cidade, pais.get(), this.telefone, this.cep);

        if (this.idEstado != null) {
            Optional<Estado> estado = estadoRepository.findById(this.idEstado);
            Assert.state(estado.isPresent(), "Não existe estado cadastrado.");
            Assert.state(estado.get().verificaPais(pais.get()), "Estado não pertece ao país.");
            cliente.setEstado(estado.get());
        }

        return cliente;
    }

}
