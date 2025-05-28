package dev.gihan.e_commerce.api.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderCreateRequestDto {

    private List<OrderItemRequestDto> items;
    private double discount;

}
