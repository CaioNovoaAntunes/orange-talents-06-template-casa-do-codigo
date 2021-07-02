package com.br.zup.casacodigo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = {CheckIfExistsValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckIfExist {
    String message() default "Instancia não encontrada";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String identityField();
    Class instanceClass();
}