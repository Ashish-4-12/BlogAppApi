package com.backendprojects.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

    private Integer categoryId;
    @NotBlank
    @Size(min = 4, message = "min size of category name is 4 !")
    private String categoryName;
    @NotBlank
    @Size(min = 10, message = "min size of category description is 10 !")
    private String categoryDescription;

}
