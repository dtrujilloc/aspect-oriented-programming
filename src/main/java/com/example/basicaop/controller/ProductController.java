package com.example.basicaop.controller;

import com.example.basicaop.common.dto.ProductRequestDto;
import com.example.basicaop.data.model.Product;
import com.example.basicaop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        log.info(">> Start getAllProducts");
        List<Product> productList = productService.getAllProducts();
        log.info("<< Finish getAllProducts -> resultSize:{}", productList.size());
        return productList;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(name = "id") Integer id) {
        log.info(">> Start getProductById -> id:{}", id);
        Product product = productService.getProductById(id);
        log.info("<< Finish getProductById -> product:{}", product);
        return product;
    }

    @PostMapping
    public Product saveProduct(@RequestBody ProductRequestDto productRequestDto) {
        log.info(">> Start saveProduct -> productRequestDto:{}", productRequestDto);
        Product product = productService.saveProduct(productRequestDto);
        log.info(">> Finish saveProduct -> result:{}", product);
        return product;
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable(name = "id") Integer id) {
        log.info(">> Start deleteProduct -> id:{}", id);
        Product product = productService.deleteProduct(id);
        log.info("<< Finish deleteProduct -> result:{}", product);
        return product;
    }
}
