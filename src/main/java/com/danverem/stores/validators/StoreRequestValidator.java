package com.danverem.stores.validators;

import com.danverem.stores.dtos.StoreDTO;
import com.danverem.stores.models.Store;
import com.danverem.stores.repositories.StoreRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
@LocalBean
public class StoreRequestValidator {

    private final static String TAKEN_MESSAGE = " has already been taken";

    @Inject
    private StoreRepository storeRepository;

    public String validateName(StoreDTO storeDTO) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", storeDTO.getName());

        List<Store> stores = storeRepository.findWithNamedQuery(Store.FIND_BY_NAME, params, 1);

        if (stores.isEmpty()) {
            return null;
        }

        return storeDTO.getName() + TAKEN_MESSAGE;
    }

    public String validateAccountCode(StoreDTO storeDTO) {
        Map<String, Object> params = new HashMap<>();
        params.put("code", storeDTO.getAccountCode());

        List<Store> stores = storeRepository.findWithNamedQuery(Store.FIND_BY_CODE, params, 1);

        if (stores.isEmpty()) {
            return null;
        }

        return storeDTO.getAccountCode() + TAKEN_MESSAGE;
    }
}
