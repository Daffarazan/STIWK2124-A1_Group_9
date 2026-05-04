package com.arl.backend.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class PagedResponseDto<T> {
    private List<T> content;
    private int currentPage;
    private long totalElements;
    private int totalPages;
    private int size;
}