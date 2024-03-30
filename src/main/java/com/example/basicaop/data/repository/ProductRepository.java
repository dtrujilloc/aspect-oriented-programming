package com.example.basicaop.data.repository;

import com.example.basicaop.data.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        return productList;
    }

    public Product getProductById(Integer id) {
        return productList.stream().filter(product -> Objects.equals(product.getId(), id)).findFirst().orElse(null);
    }

    public Product saveProduct(Product product) {

        if(productList.isEmpty())
        {
            product.setId(1);
        }
        else {
            Product lastProductSaved = productList.get(productList.size()-1);

            product.setId(lastProductSaved.getId() + 1);
        }

        productList.add(product);

        return product;
    }

    public Product deleteProduct(Integer id) {
        Product product = getProductById(id);

        if (product != null) {
            productList.remove(product);
        }
        else {
            throw new RuntimeException("The product doesn't exist");
        }

        return product;
    }

}
