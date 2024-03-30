package com.example.basicaop.common.mapper;

import com.example.basicaop.common.dto.ProductRequestDto;
import com.example.basicaop.data.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product convertProductRequestDtoToProductModel(ProductRequestDto productRequestDto) {
        return Product.builder()
                .name(productRequestDto.getName())
                .price(productRequestDto.getPrice())
                .build();
    }
}
