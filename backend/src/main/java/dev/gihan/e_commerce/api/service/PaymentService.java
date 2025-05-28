package dev.gihan.e_commerce.api.service;

import dev.gihan.e_commerce.api.dto.requestDto.PaymentRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.PaymentResponseDto;
import dev.gihan.e_commerce.api.exception.PaymentAlreadyExistsException;

public interface PaymentService {

    PaymentResponseDto makePayment(PaymentRequestDto dto, String username) throws PaymentAlreadyExistsException;
    PaymentResponseDto getPaymentForOrder(Long orderId, String username);

}

