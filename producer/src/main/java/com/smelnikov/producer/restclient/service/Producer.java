package com.smelnikov.producer.restclient.service;

import com.smelnikov.libs.dto.Product;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@Slf4j
@NoArgsConstructor
public class Producer {
    private static final String TOPIC = "user";

    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

    @Value(value = TOPIC)
    private String topicName;

    public void sendMessage(Product product){
        ListenableFuture<SendResult<String, Product>> listenableFuture = kafkaTemplate.send(topicName, product);

        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, Product>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send message = {} to: {}", product, ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Product> result) {
                log.info("Sent Message = {} with offset = {}", product, result.getRecordMetadata().offset());
            }
        });
    }

}