package dev.gihan.e_commerce.api.service;

import dev.gihan.e_commerce.api.dto.requestDto.OrderCreateRequestDto;
import dev.gihan.e_commerce.api.dto.requestDto.OrderItemRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.OrderResponseDto;
import dev.gihan.e_commerce.api.exception.OrderNotFoundException;

import java.util.List;

public interface OrderService {

    OrderResponseDto createOrder(OrderCreateRequestDto dto, String username);
    List<OrderResponseDto> getMyOrders(String username);
    OrderResponseDto addItemsToOrder(Long orderId, List<OrderItemRequestDto> items, String username) throws OrderNotFoundException;
    void cancelOrder(Long orderId, String username);


}

