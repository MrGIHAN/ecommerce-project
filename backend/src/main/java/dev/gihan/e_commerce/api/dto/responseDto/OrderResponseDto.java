package dev.gihan.e_commerce.api.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderResponseDto {

    private Long orderId;
    private double discount;
    private double total;
    private boolean isCancelled;
    private String status;
    private List<OrderItemDto> items;
}

