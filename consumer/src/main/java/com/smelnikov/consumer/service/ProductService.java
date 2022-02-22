package com.smelnikov.consumer.service;

import com.smelnikov.consumer.repository.ProductRepository;
import com.smelnikov.libs.dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public void saveMessage(Product product){
        repository.save(product);
    }
}
