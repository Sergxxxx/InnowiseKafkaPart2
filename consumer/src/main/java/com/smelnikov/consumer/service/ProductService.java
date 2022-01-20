package com.smelnikov.consumer.service;

import com.smelnikov.consumer.repository.ProductRepository;
import com.smelnikov.libs.dto.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product saveMessage(Product product){
        return repository.save(product);
    }

}