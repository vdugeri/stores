package com.danverem.stores.services;

import com.danverem.stores.dtos.PaginatedResource;
import com.danverem.stores.dtos.StoreDTO;
import com.danverem.stores.mappers.StoreMapper;
import com.danverem.stores.models.Store;
import com.danverem.stores.repositories.StoreRepository;
import com.danverem.stores.utils.PaginationMetadata;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Stateless
@LocalBean
public class StoreService {


    @Inject
    private StoreRepository storeRepository;


    public PaginatedResource<StoreDTO> getAll(int limit, int offset) {
        int total = storeRepository.count();
        List<Store> stores = storeRepository.findWithLimitAndOffset(limit, offset);

        int pages = (int) Math.ceil(total / limit) + 1;
        int currPage = (int) Math.floor(offset / limit) + 1;

        PaginationMetadata metadata = new PaginationMetadata();
        metadata.setPerPage(limit);
        metadata.setTotal(total);
        metadata.setPages(pages);
        metadata.setCurrPage(currPage);

        PaginatedResource<StoreDTO> paginatedStores = new PaginatedResource<>();
        paginatedStores.setMeta(metadata);
        paginatedStores.setData(StoreMapper.mapTo(stores));

        return paginatedStores;
    }

    public Optional<Store> find(Long ID) {
        return Optional.ofNullable(storeRepository.find(ID));
    }

    public Store create(StoreDTO store) {
        return storeRepository.create(StoreMapper.mapTo(store));
    }

    public Store edit(Long ID, StoreDTO storeDTO) {
        Optional<Store> store = find(ID);

        if (store.isPresent()) {
            return storeRepository.edit(StoreMapper.mapTo(storeDTO));
        }

        throw new EntityNotFoundException("Store not found");
    }

    public void delete(Long ID) {
        storeRepository.delete(ID);
    }
}
