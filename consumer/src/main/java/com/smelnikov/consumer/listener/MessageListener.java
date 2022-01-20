package com.smelnikov.consumer.listener;

import com.smelnikov.consumer.service.ProductService;
import com.smelnikov.libs.dto.Product;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class MessageListener {
    private static final String TOPIC = "user";

    @Autowired
    private ProductService productService;

    @KafkaListener(topics = TOPIC, containerFactory = "kafkaListenerContainerFactory", groupId = ConsumerConfig.GROUP_ID_CONFIG)
    public void listener (Product product){
        System.out.println("Recieved message: " + product);
        productService.saveMessage(product);
    }

}