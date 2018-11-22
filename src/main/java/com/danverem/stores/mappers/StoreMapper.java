package com.danverem.stores.mappers;

import com.danverem.stores.dtos.StoreDTO;
import com.danverem.stores.models.Store;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StoreMapper {


    public static Store mapTo(StoreDTO storeDTO) {
        if (storeDTO == null) {
            return null;
        }

        Store store = new Store();
        store.setID(storeDTO.getID());
        store.setAccountCode(storeDTO.getAccountCode());
        store.setAddress(storeDTO.getAddress());
        store.setName(storeDTO.getName());

        return store;
    }

    public static StoreDTO mapTo(Store store) {
        if (store == null) {
            return null;
        }

        return new StoreDTO(
            store.getID(),
            store.getName(),
            store.getAddress(),
            store.getAccountCode()
        );
    }

    public static List<StoreDTO> mapTo(List<Store> stores) {
        if (stores.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return stores
            .stream()
            .map(store -> mapTo(store))
            .filter(store -> store != null)
            .collect(Collectors.toList());
    }
}
