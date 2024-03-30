package com.example.basicaop.controller;

import com.example.basicaop.common.dto.ProductRequestDto;
import com.example.basicaop.data.model.Product;
import com.example.basicaop.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(name = "id") Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody ProductRequestDto productRequestDto) {
        Product product = productService.saveProduct(productRequestDto);
        return product;
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable(name = "id") Integer id) {
        return productService.deleteProduct(id);
    }
}
