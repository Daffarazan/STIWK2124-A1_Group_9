package com.arl.backend.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class BookResponseDto {
    private Long id;
    private String title;
    private String author;
    private String category;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}