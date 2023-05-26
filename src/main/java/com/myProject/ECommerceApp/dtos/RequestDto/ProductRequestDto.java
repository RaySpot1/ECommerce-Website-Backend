package com.myProject.ECommerceApp.dtos.RequestDto;

import com.myProject.ECommerceApp.model.Product;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
    private Integer Id;

    private @NotNull String name;

    private @NotNull String imageUrl;

    private @NotNull double price;

    private @NotNull String description;

    private @NotNull Integer categoryId;

    public ProductRequestDto(Product product) {
    }
}
