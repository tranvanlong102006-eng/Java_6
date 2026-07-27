package com.example.java6.buoi1.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ProductRequest {

    @NotBlank(message = "Product Code không được để trống!")
    private String productCode;

    @NotBlank(message = "Product Name không được để trống!")
    private String productName;

    @NotNull(message = "Category không được để trống!")
    private Integer categoryId;

    @NotNull(message = "Price không được để trống!")
    private float price;

    @NotBlank(message = "Description không được để trống!")
    private String description;
}
