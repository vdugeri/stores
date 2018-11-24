package com.danverem.stores.repositories;

import com.danverem.stores.models.Item;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class ItemRepository extends AbstractRepository<Item> {

    @PersistenceContext(unitName = "storesPU")
    private EntityManager entityManager;

    public ItemRepository() {
        super(Item.class);
    }

    @Override
    EntityManager getEntityManager() {
        return entityManager;
    }
}
