package com.example.restclientpocproductpricesservice.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PageData<T> {
    private List<T> items;
    private int page;           // 0-based
    private int size;           // page size actually used
    private long totalElements; // total rows
    private int totalPages;     // total pages
}
