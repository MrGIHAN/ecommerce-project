package dev.gihan.e_commerce.api.controller;


import dev.gihan.e_commerce.api.dto.requestDto.PaymentRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.GenericResponse;
import dev.gihan.e_commerce.api.dto.responseDto.PaymentResponseDto;
import dev.gihan.e_commerce.api.exception.PaymentAlreadyExistsException;
import dev.gihan.e_commerce.api.service.PaymentService;
import dev.gihan.e_commerce.api.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

        @Autowired
        private PaymentService paymentService;

        @PostMapping
        public ResponseEntity<GenericResponse<PaymentResponseDto>> makePayment(
                @RequestBody PaymentRequestDto dto,
                @AuthenticationPrincipal CustomUserDetails user) throws PaymentAlreadyExistsException {

            PaymentResponseDto response = paymentService.makePayment(dto, user.getUsername());
            GenericResponse<PaymentResponseDto> wrapped = new GenericResponse<>("💰 Payment successful", response);

            return new ResponseEntity<>(wrapped, HttpStatus.CREATED);
        }

        @GetMapping("/order/{orderId}")
        public ResponseEntity<GenericResponse<PaymentResponseDto>> getPaymentByOrder(
                @PathVariable Long orderId,
                @AuthenticationPrincipal CustomUserDetails user) {

            PaymentResponseDto response = paymentService.getPaymentForOrder(orderId, user.getUsername());
            GenericResponse<PaymentResponseDto> wrapped = new GenericResponse<>("✅ Payment record fetched", response);

            return ResponseEntity.ok(wrapped);
        }

}

