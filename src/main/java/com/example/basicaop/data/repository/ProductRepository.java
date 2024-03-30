package com.example.basicaop.data.repository;

import com.example.basicaop.data.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@Repository
public class ProductRepository {

    private List<Product> productList;

    public ProductRepository() {
        initProductList();
    }

    private void initProductList() {
        productList = new ArrayList<>(Arrays.asList(Product.builder().id(1).name("TV").price(100.0).build(),
                Product.builder().id(2).name("Cellphone").price(50.5).build(),
                Product.builder().id(3).name("Tablet").price(70.6).build()));
    }

    public List<Product> getAllProducts() {
        log.info("**> Start getAllProducts");
        List<Product> products = productList;
        log.info("<** Finish getAllProducts");
        return products;
    }

    public Product getProductById(Integer id) {
        log.info("**> Start getProductById");
        Product product = productList.stream().filter(productTemp -> Objects.equals(productTemp.getId(), id)).findFirst().orElse(null);
        log.info("<** Finish getProductById");
        return product;
    }

    public Product saveProduct(Product product) {
        log.info("**> Start saveProduct");

        if(productList.isEmpty())
        {
            product.setId(1);
        }
        else {
            Product lastProductSaved = productList.get(productList.size()-1);

            product.setId(lastProductSaved.getId() + 1);
        }

        productList.add(product);

        log.info("<** Finish saveProduct");
        return product;
    }

    public Product deleteProduct(Integer id) {
        log.info("**> Start deleteProduct");
        Product product = getProductById(id);

        if (product != null) {
            productList.remove(product);
        }
        else {
            throw new RuntimeException("The product doesn't exist");
        }

        log.info("<** Finish deleteProduct");
        return product;
    }

}
