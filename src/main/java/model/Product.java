package model;

import lombok.Builder;
import lombok.Data;


@Data
public class Product {
    private int id;
    private String name; // 바지

    @Builder
    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }
}



