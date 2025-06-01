package dev.gihan.e_commerce.api.dto.responseDto;

import dev.gihan.e_commerce.api.model.option.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeliveryResponseDto {

    private Long deliveryId;
    private String address;
    private String trackingNumber;
    private DeliveryStatus status;
    private LocalDate deliveryDate;
    private Long orderId;

}

