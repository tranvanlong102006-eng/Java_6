package com.example.java6.buoi1.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CategoryResponse {

    private Integer id;

    private String categoryCode;

    private String categoryName;
}
