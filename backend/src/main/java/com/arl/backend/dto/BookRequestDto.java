package com.arl.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class BookRequestDto {
    @NotBlank(message = "Title is required")
    @Size(min = 2, max = 255, message = "Title must be between 2 and 255 characters")
    private String title;

    @NotBlank(message = "Author is required")
    @Size(min = 2, max = 255, message = "Author must be between 2 and 255 characters")
    private String author;

    @NotBlank(message = "Category is required")
    @Size(min = 2, max = 100, message = "Category must be between 2 and 100 characters")
    private String category;

    @Size(max = 2000, message = "Description must not exceed 2000 characters")
    private String description;
}