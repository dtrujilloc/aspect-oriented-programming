package com.example.basicaop.service;

import com.example.basicaop.common.dto.ProductRequestDto;
import com.example.basicaop.common.mapper.ProductMapper;
import com.example.basicaop.data.model.Product;
import com.example.basicaop.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProductById(Integer id) {
        return productRepository.getProductById(id);
    }

    public Product saveProduct(ProductRequestDto productRequestDto) {
        Product productToSave = productMapper.convertProductRequestDtoToProductModel(productRequestDto);
        Product productSaved = productRepository.saveProduct(productToSave);
        return productSaved;
    }

    public Product deleteProduct(Integer id) {
        return productRepository.deleteProduct(id);
    }
}
