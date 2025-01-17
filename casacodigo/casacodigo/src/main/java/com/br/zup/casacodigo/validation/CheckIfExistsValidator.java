package com.br.zup.casacodigo.validation;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
public class CheckIfExistsValidator implements ConstraintValidator<CheckIfExist, Object> {

    private String atributo;
    private Class<?> classe;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(CheckIfExist existeValid) {
        atributo = existeValid.identityField();
        classe = existeValid.instanceClass();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("select 1 from " + classe.getName() + " where " + atributo + "=:value");
        query.setParameter("value", obj);
        List<?> list = query.getResultList();

        if (list.isEmpty()) {
            return false;
        }

        return true;
    }
}
