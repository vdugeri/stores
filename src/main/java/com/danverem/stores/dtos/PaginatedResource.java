package com.danverem.stores.dtos;

import com.danverem.stores.utils.PaginationMetadata;

import java.util.List;

public class PaginatedResource<T> {

    private PaginationMetadata meta;
    private List<T> data;

    public PaginationMetadata getMeta() {
        return meta;
    }

    public void setMeta(PaginationMetadata meta) {
        this.meta = meta;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
