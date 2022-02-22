package com.smelnikov.consumer.config;

import com.smelnikov.consumer.service.ProductService;
import com.smelnikov.libs.dto.Product;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageListener {

    private static final String TOPIC = "user";
    private final ProductService productService;

    @KafkaListener(topics = TOPIC, containerFactory = "kafkaListenerContainerFactory", groupId = ConsumerConfig.GROUP_ID_CONFIG)
    public void listener (Product product){
        System.out.println("Recieved message: " + product);
        productService.saveMessage(product);
    }
}
