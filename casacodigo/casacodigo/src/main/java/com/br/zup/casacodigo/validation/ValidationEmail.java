package com.br.zup.casacodigo.validation;


import com.br.zup.casacodigo.autor.Autor;
import com.br.zup.casacodigo.autor.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ValidationEmail implements ConstraintValidator<ValidationEmailValid, String> {

    private String value;

    @Autowired
    AutorRepository repository;

    @Override
    public void initialize(ValidationEmailValid constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String request, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Autor> autorExiste = repository.findByEmail(request);
        if (autorExiste.isPresent()){
            return false;
        }
        return true;
    }
}