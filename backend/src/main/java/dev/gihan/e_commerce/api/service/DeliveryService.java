package dev.gihan.e_commerce.api.service;

import dev.gihan.e_commerce.api.dto.requestDto.DeliveryRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.DeliveryResponseDto;

public interface DeliveryService {

    DeliveryResponseDto createOrUpdateDelivery(DeliveryRequestDto dto);
    DeliveryResponseDto getDeliveryByOrder(Long orderId, String username);

}

