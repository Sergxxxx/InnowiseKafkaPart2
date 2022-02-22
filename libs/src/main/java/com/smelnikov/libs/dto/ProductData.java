package com.smelnikov.libs.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductData {
    private List<Product> data = new ArrayList<>();

    public List<Product> getData() {
        return data;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }
}
