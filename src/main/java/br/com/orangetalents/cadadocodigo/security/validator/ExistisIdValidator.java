package br.com.orangetalents.cadadocodigo.security.validator;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistisIdValidator implements ConstraintValidator<ExistisId, Object> {

    private String domainAttribute;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ExistisId params) {

        this.domainAttribute = params.fieldName();
        this.klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Query query = manager.createQuery("SELECT 1 FROM "+klass.getName()+" where "+domainAttribute+"=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();

        Assert.state(list.size() >= 0 , "Não foi encontrado nenhum "+ this.klass +" pelo id "+this.domainAttribute+"= "+value);

        return !(list.isEmpty());
    }
}
