package com.danverem.stores.mappers;

import com.danverem.stores.dtos.ItemDTO;
import com.danverem.stores.models.Item;
import com.danverem.stores.utils.SimpleDateConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ItemMapper {

    public static ItemDTO mapTo(Item item) {
        if (item == null) {
            return null;
        }

        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setDateIn(SimpleDateConverter.dateToString(item.getDateIn(), "yyyy-MM-dd HH:mm:ss"));
        itemDTO.setID(item.getID());
        itemDTO.setName(item.getName());
        itemDTO.setPurchasePrice(item.getPurchasePrice());
        itemDTO.setSellingPrice(item.getSellingPrice());
        itemDTO.setQuantity(item.getQuantity());

        return itemDTO;
    }

    public static Item mapTo(ItemDTO itemDTO) {
        if (itemDTO == null) {
            return null;
        }

        Item item = new Item();
        item.setDateIn(SimpleDateConverter.stringToDate(itemDTO.getDateIn(), "yyyy-MM-dd HH:mm:ss"));
        item.setID(itemDTO.getID());
        item.setName(itemDTO.getName());
        item.setPurchasePrice(itemDTO.getPurchasePrice());
        item.setSellingPrice(itemDTO.getSellingPrice());
        item.setQuantity(itemDTO.getQuantity());

        return item;
    }

    public static List<ItemDTO> mapTo(List<Item> items) {
        if (items.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return items
            .stream()
            .map(item -> mapTo(item))
            .filter(item -> item != null)
            .collect(Collectors.toList());
    }
}
