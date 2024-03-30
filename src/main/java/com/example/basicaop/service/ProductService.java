package com.example.basicaop.service;

import com.example.basicaop.common.dto.ProductRequestDto;
import com.example.basicaop.common.mapper.ProductMapper;
import com.example.basicaop.data.model.Product;
import com.example.basicaop.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<Product> getAllProducts() {
        log.info("--> Start getAllProducts");
        List<Product> productList = productRepository.getAllProducts();
        log.info("<-- Finish getAllProducts");
        return productList;
    }

    public Product getProductById(Integer id) {
        log.info("--> Start getProductById");
        Product product = productRepository.getProductById(id);
        log.info("<-- Finish getProductById");
        return product;
    }

    public Product saveProduct(ProductRequestDto productRequestDto) {
        log.info("--> Start saveProduct");
        Product productToSave = productMapper.convertProductRequestDtoToProductModel(productRequestDto);
        Product productSaved = productRepository.saveProduct(productToSave);
        log.info("<-- Finish saveProduct");
        return productSaved;
    }

    public Product deleteProduct(Integer id) {
        log.info("--> Start deleteProduct");
        Product product = productRepository.deleteProduct(id);
        log.info("<-- Finish deleteProduct");
        return product;
    }
}
