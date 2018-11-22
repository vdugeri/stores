package com.danverem.stores.repositories;

import com.danverem.stores.models.Store;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class StoreRepository extends AbstractRepository<Store> {

    @PersistenceContext(unitName = "storesPU")
    private EntityManager entityManager;


    public StoreRepository() {
        super(Store.class);
    }

    @Override
    EntityManager getEntityManager() {
        return this.entityManager;
    }
}
