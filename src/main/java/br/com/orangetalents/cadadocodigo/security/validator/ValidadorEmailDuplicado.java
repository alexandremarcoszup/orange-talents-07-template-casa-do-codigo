package br.com.orangetalents.cadadocodigo.security.validator;

import br.com.orangetalents.cadadocodigo.controller.request.AutorRequest;
import br.com.orangetalents.cadadocodigo.domain.entity.Autor;
import br.com.orangetalents.cadadocodigo.domain.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidadorEmailDuplicado implements Validator {

    @Autowired
    private AutorRepository repository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AutorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            return;
        }
        AutorRequest request = (AutorRequest) target;
        Optional<Autor> optionalAutorRequest = repository.findByEmail(request.getEmail());

        if (optionalAutorRequest.isPresent()){
            errors.rejectValue("email",null, "Email já existente!" + request.getEmail());
        }
    }
}
