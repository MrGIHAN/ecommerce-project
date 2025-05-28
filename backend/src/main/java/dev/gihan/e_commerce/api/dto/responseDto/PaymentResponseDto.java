package dev.gihan.e_commerce.api.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentResponseDto {

    private Long paymentId;
    private boolean successful;
    private String method;
    private String transactionReference;
    private Long orderId;

}

