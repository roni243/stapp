package model;

import lombok.Builder;
import lombok.Data;

@Data
public class ProductOption {
    private int id;
    private String name;
    private int price;
    private int qty;

    private Product product;

    @Builder
    public ProductOption(int id, String name, int price, int qty, Product product) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.product = product;
    }
}
