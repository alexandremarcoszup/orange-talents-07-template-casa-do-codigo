package br.com.orangetalents.cadadocodigo.controller.request;

import br.com.orangetalents.cadadocodigo.domain.entity.Estado;
import br.com.orangetalents.cadadocodigo.domain.entity.Pais;
import br.com.orangetalents.cadadocodigo.domain.repository.PaisRepository;
import br.com.orangetalents.cadadocodigo.security.validator.ExistisId;
import br.com.orangetalents.cadadocodigo.security.validator.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class EstadoRequest {

    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @NotNull
    @ExistisId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    public EstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado requestToDomain(PaisRepository paisRepository) {
        Optional<Pais> pais = paisRepository.findById(this.idPais);

        return new Estado(this.nome, pais.get());
    }
}
