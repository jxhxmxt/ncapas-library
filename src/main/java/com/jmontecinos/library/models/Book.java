package com.jmontecinos.library.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @NotNull
    @NotBlank
    @Pattern(regexp= "^(97([89]))?\\d{9}(\\d|X)$", message="Invalid ISBN format")
    private String isbn;

    @NotNull
    @NotBlank
    private String title;
}
