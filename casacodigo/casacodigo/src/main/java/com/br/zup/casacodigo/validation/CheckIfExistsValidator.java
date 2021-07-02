package com.br.zup.casacodigo.validation;
import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckIfExistsValidator implements ConstraintValidator<CheckIfExist, Object> {
    private EntityManager em;

    private Class<?> object;
    private String identityField;

    public CheckIfExistsValidator(EntityManager em) {
        this.em = em;
    }

    @Override
    public void initialize(CheckIfExist constraintAnnotation) {
        this.object = constraintAnnotation.instanceClass();
        this.identityField = constraintAnnotation.identityField();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null){
            return true;
        }
        return !this.em.createQuery("select 1 from "+this.object.getName()+" where "+ this.identityField + "=:field")
                .setParameter("field",value)
                .getResultList()
                .isEmpty();
    }
}