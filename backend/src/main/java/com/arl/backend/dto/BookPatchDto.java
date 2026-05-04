package com.arl.backend.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class BookPatchDto {
    @Size(min = 2, max = 255)
    private String title;

    @Size(min = 2, max = 255)
    private String author;

    @Size(min = 2, max = 100)
    private String category;

    @Size(max = 2000)
    private String description;
}