package dev.gihan.e_commerce.api.controller;

import dev.gihan.e_commerce.api.dto.requestDto.OrderCreateRequestDto;
import dev.gihan.e_commerce.api.dto.requestDto.OrderItemRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.OrderResponseDto;
import dev.gihan.e_commerce.api.exception.OrderNotFoundException;
import dev.gihan.e_commerce.api.security.CustomUserDetails;
import dev.gihan.e_commerce.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(
            @RequestBody OrderCreateRequestDto dto,
            @AuthenticationPrincipal CustomUserDetails user) {
        return new ResponseEntity<>(orderService.createOrder(dto, user.getUsername()), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> getOrders(
            @AuthenticationPrincipal CustomUserDetails user) {
        return ResponseEntity.ok(orderService.getMyOrders(user.getUsername()));
    }

    @PutMapping("/{orderId}/add-items")
    public ResponseEntity<OrderResponseDto> addItems(
            @PathVariable Long orderId,
            @RequestBody List<OrderItemRequestDto> items,
            @AuthenticationPrincipal CustomUserDetails user) throws OrderNotFoundException {
        return ResponseEntity.ok(orderService.addItemsToOrder(orderId, items, user.getUsername()));
    }

    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<Void> cancelOrder(
            @PathVariable Long orderId,
            @AuthenticationPrincipal CustomUserDetails user) {
        orderService.cancelOrder(orderId, user.getUsername());
        return ResponseEntity.ok().build();
    }
}

