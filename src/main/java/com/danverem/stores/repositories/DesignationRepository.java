package com.danverem.stores.repositories;

import com.danverem.stores.models.Designation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class DesignationRepository extends AbstractRepository<Designation> {

    @PersistenceContext(unitName = "storesPU")
    private EntityManager entityManager;

    public DesignationRepository() {
        super(Designation.class);
    }

    @Override
    EntityManager getEntityManager() {
        return entityManager;
    }
}
