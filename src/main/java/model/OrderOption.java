package model;

import lombok.Builder;
import lombok.Data;

// 주문 옵션 (바지XL, 티L)
@Data
public class OrderOption {
    private int id;
    private String optionName; // 하얀티
    private int qty; // 5개
    private int totalPrice; // 10000원

    private Product product;
    private Order order;

    @Builder
    public OrderOption(int id, String optionName, int qty, int totalPrice, Product product, Order order) {
        this.id = id;
        this.optionName = optionName;
        this.qty = qty;
        this.totalPrice = totalPrice;
        this.product = product;
        this.order = order;
    }
}
