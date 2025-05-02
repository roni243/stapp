package ex03;

import lombok.Data;
import model.OrderOption;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class OrderDetailDTO {
    private int orderId;
    private List<ProductDTO> products = new ArrayList<>();
    private int sumPrice;

    public OrderDetailDTO(List<OrderOption> orderOptions) {
        this.orderId = orderOptions.get(0).getId();

        // 중복이 제거된 상품 ids + 전체금액 계산
        Set<Integer> productIds = new HashSet<>();
        for (OrderOption orderOption : orderOptions) {
            productIds.add(orderOption.getProduct().getId());
            this.sumPrice += orderOption.getTotalPrice();
        }

        // 상품별 주문한 상품옵션 만들기
        for (Integer productId : productIds) {

            List<OrderOption> selectedOptions = new ArrayList<>();

            for (OrderOption orderOption : orderOptions) {
                if (productId == orderOption.getProduct().getId()) {
                    selectedOptions.add(orderOption);
                }
            }

            ProductDTO productDTO = new ProductDTO(productId, selectedOptions);
            this.products.add(productDTO);
        }
    }

    @Data
    class ProductDTO {
        private int productId;
        private List<OrderOptionDTO> orderOptions = new ArrayList<>();

        public ProductDTO(int productId, List<OrderOption> orderOptions) {
            this.productId = productId;

            for (OrderOption orderOption : orderOptions) {
                this.orderOptions.add(new OrderOptionDTO(orderOption));
            }
        }

        @Data
        class OrderOptionDTO {
            private int orderOptionId;
            private String orderOptionName;
            private int orderQty;
            private int orderTotalPrice;

            public OrderOptionDTO(OrderOption orderOption) {
                this.orderOptionId = orderOption.getId();
                this.orderOptionName = orderOption.getOptionName();
                this.orderQty = orderOption.getQty();
                this.orderTotalPrice = orderOption.getTotalPrice();
            }
        }
    }
}