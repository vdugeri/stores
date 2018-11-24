package com.danverem.stores.services;

import com.danverem.stores.dtos.ItemDTO;
import com.danverem.stores.dtos.PaginatedResource;
import com.danverem.stores.mappers.ItemMapper;
import com.danverem.stores.models.Item;
import com.danverem.stores.repositories.ItemRepository;
import com.danverem.stores.utils.PaginationMetadata;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Stateless
@LocalBean
public class ItemService {

    @Inject
    private ItemRepository itemRepository;

    public PaginatedResource<ItemDTO> getAll(int limit, int offset) {
        List<Item> items = itemRepository.findWithLimitAndOffset(limit, offset);

        if (items.isEmpty()) {
            return new PaginatedResource<>();
        }

        int total = itemRepository.count();
        int pages = (int) Math.ceil(total / limit) + 1;
        int currPage = (int) Math.floor(offset / limit) + 1;

        PaginationMetadata metadata = new PaginationMetadata();
        metadata.setCurrPage(currPage);
        metadata.setPages(pages);
        metadata.setTotal(total);
        metadata.setPerPage(limit);

        PaginatedResource<ItemDTO> itemsPaginated = new PaginatedResource<>();
        itemsPaginated.setData(ItemMapper.mapTo(items));
        itemsPaginated.setMeta(metadata);

        return itemsPaginated;
    }

    public ItemDTO create(ItemDTO itemDTO) {
        return ItemMapper.mapTo(itemRepository.create(ItemMapper.mapTo(itemDTO)));
    }


    public Optional<ItemDTO> find(Long ID) {
        return Optional.ofNullable(ItemMapper.mapTo(itemRepository.find(ID)));
    }


    public Optional<ItemDTO> edit(Long ID, ItemDTO item) {
        Optional<ItemDTO> foundItem = find(ID);

        if (foundItem.isPresent()) {
            return Optional.ofNullable(ItemMapper.mapTo(itemRepository.edit(ItemMapper.mapTo(item))));
        }

        return Optional.empty();
    }

    public void delete(Long ID) {
        itemRepository.delete(ID);
    }


}
