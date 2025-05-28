package dev.gihan.e_commerce.api.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentRequestDto {

    private Long orderId;
    private String method;
    private String transactionReference;

}

