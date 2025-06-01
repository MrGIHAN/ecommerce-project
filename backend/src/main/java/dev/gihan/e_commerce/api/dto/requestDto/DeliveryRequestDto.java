package dev.gihan.e_commerce.api.dto.requestDto;

import dev.gihan.e_commerce.api.model.option.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeliveryRequestDto {

    private Long orderId;
    private String address;
    private String trackingNumber;
    private DeliveryStatus status;

}

