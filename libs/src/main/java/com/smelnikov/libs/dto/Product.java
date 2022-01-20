package com.smelnikov.libs.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Product implements Serializable {

    @Id
    private ObjectId id;
    private String product_name;
    private String description;
    private byte[] picture;
    private String type;

}