package model;

import lombok.Builder;
import lombok.Data;

// 주문
@Data
public class Order {
    private int id;

    @Builder
    public Order(int id) {
        this.id = id;
    }
}