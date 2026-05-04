package com.arl.backend.service;

import org.springframework.data.domain.Pageable;

import com.arl.backend.dto.BookPatchDto;
import com.arl.backend.dto.BookRequestDto;
import com.arl.backend.dto.BookResponseDto;
import com.arl.backend.dto.PagedResponseDto;

public interface BookService {
    BookResponseDto create(BookRequestDto dto);
    PagedResponseDto<BookResponseDto> findAll(String query, Pageable pageable);
    BookResponseDto findById(Long id);
    BookResponseDto update(Long id, BookRequestDto dto);
    BookResponseDto patch(Long id, BookPatchDto dto);
    void delete(Long id);
}