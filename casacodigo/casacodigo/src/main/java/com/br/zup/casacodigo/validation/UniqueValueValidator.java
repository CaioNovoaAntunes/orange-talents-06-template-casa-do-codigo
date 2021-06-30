package com.br.zup.casacodigo.validation;

import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {
    private EntityManager em;

    private Class<?> object;
    private String field;

    public UniqueValueValidator(EntityManager em) {
        this.em = em;
    }

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        this.object = constraintAnnotation.instanceClass();
        this.field = constraintAnnotation.field();
        ConstraintValidator.super.initialize(constraintAnnotation);


    }
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return this.em.createQuery("select 1 from " + this.object.getName() + " where " + field + "=:field")
                .setParameter("field", value)
                .getResultList()
                .isEmpty();
    }

}