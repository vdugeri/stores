package com.danverem.stores.repositories;

import com.danverem.stores.models.User;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Verem Dugeri <verem.dugeri@gmail.com>
 */
@Stateless
@LocalBean
public class UserRepository extends AbstractRepository<User> {

    @PersistenceContext(unitName = "storesPU")
    private EntityManager entityManager;


    public UserRepository() {
        super(User.class);
    }

    @Override
    EntityManager getEntityManager() {
        return entityManager;
    }
}
