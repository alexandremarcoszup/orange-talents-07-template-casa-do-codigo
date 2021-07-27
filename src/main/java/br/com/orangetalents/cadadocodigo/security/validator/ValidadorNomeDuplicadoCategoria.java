package br.com.orangetalents.cadadocodigo.security.validator;

import br.com.orangetalents.cadadocodigo.controller.request.CategoriaRequest;
import br.com.orangetalents.cadadocodigo.domain.entity.Categoria;
import br.com.orangetalents.cadadocodigo.domain.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidadorNomeDuplicadoCategoria implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            return;
        }
        CategoriaRequest request = (CategoriaRequest) target;
        Optional<Categoria> categoriaOptional = categoriaRepository.findByNome(request.getNome());

        if (categoriaOptional.isPresent()){
            errors.rejectValue("nome", "Categoria já existente" + request.getNome());
        }

    }
}
