package dev.gihan.e_commerce.api.controller;

import dev.gihan.e_commerce.api.dto.requestDto.DeliveryRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.DeliveryResponseDto;
import dev.gihan.e_commerce.api.dto.responseDto.GenericResponse;
import dev.gihan.e_commerce.api.security.CustomUserDetails;
import dev.gihan.e_commerce.api.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<GenericResponse<DeliveryResponseDto>> createOrUpdateDelivery(
            @RequestBody DeliveryRequestDto dto) {
        DeliveryResponseDto response = deliveryService.createOrUpdateDelivery(dto);
        return new ResponseEntity<>(
                new GenericResponse<>("🚚 Delivery info saved", response),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<GenericResponse<DeliveryResponseDto>> getDeliveryByOrder(
            @PathVariable Long orderId,
            @AuthenticationPrincipal CustomUserDetails user) {
        DeliveryResponseDto response = deliveryService.getDeliveryByOrder(orderId, user.getUsername());
        return ResponseEntity.ok(new GenericResponse<>("📦 Delivery info fetched", response));
    }
}

