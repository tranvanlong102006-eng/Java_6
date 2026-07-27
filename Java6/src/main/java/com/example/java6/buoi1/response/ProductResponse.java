package com.example.java6.buoi1.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ProductResponse {

    private Integer id;

    private String productCode;

    private String productName;

    private String categoryCode;

    private String categoryName;

    private float price;

    private String description;
}
