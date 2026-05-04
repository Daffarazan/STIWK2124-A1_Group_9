package com.arl.backend.service;

import com.arl.backend.dto.BookPatchDto;
import com.arl.backend.dto.BookRequestDto;
import com.arl.backend.dto.BookResponseDto;
import com.arl.backend.dto.PagedResponseDto;
import com.arl.backend.entity.Book;
import com.arl.backend.exception.ResourceNotFoundException;
import com.arl.backend.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    @Transactional
    public BookResponseDto create(BookRequestDto dto) {
        Book book = new Book();
        mapDtoToEntity(dto, book);
        return toDto(bookRepository.save(book));
    }

    @Override
    @Transactional(readOnly = true)
    public PagedResponseDto<BookResponseDto> findAll(String query, Pageable pageable) {
        Page<Book> page = StringUtils.hasText(query)
                ? bookRepository.search(query.trim(), pageable)
                : bookRepository.findAll(pageable);
                
        List<BookResponseDto> content = page.getContent()
                .stream().map(this::toDto).collect(Collectors.toList());
                
        return new PagedResponseDto<>(content, page.getNumber(),
                page.getTotalElements(), page.getTotalPages(), page.getSize());
    }

    @Override
    @Transactional(readOnly = true)
    public BookResponseDto findById(Long id) {
        return toDto(findOrThrow(id));
    }

    @Override
    @Transactional
    public BookResponseDto update(Long id, BookRequestDto dto) {
        Book book = findOrThrow(id);
        mapDtoToEntity(dto, book);
        return toDto(bookRepository.save(book));
    }

    @Override
    @Transactional
    public BookResponseDto patch(Long id, BookPatchDto dto) {
        Book book = findOrThrow(id);
        if (StringUtils.hasText(dto.getTitle())) book.setTitle(dto.getTitle());
        if (StringUtils.hasText(dto.getAuthor())) book.setAuthor(dto.getAuthor());
        if (StringUtils.hasText(dto.getCategory())) book.setCategory(dto.getCategory());
        if (dto.getDescription() != null) book.setDescription(dto.getDescription());
        
        return toDto(bookRepository.save(book));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        bookRepository.delete(findOrThrow(id));
    }

    private Book findOrThrow(Long id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Book not found with id: " + id));
    }

    private void mapDtoToEntity(BookRequestDto dto, Book book) {
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setCategory(dto.getCategory());
        book.setDescription(dto.getDescription());
    }

    private BookResponseDto toDto(Book b) {
        return new BookResponseDto(b.getId(), b.getTitle(), b.getAuthor(),
                b.getCategory(), b.getDescription(), b.getCreatedAt(), b.getUpdatedAt());
    }
}