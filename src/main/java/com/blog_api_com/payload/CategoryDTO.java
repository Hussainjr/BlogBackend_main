package com.blog_api_com.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {

    private Integer categoryId;

    @NotBlank
    @Size(min = 4, message = "Title cannot be less than 4!")
    private String categoryTitle;

    @NotBlank
    @Size(min = 10, message = "Description cannot be less than 10 characters!")
    private String categoryDescription;

}
