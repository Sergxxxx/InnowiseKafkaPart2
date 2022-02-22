package com.smelnikov.consumer.batch;

import lombok.NonNull;
import com.smelnikov.libs.dto.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class ProductItemProcessor implements ItemProcessor<Product, Product> {

    @Override
    public Product process(@NonNull Product product) {
        log.info("processing product data.....{}", product);
        return product;
    }
}
