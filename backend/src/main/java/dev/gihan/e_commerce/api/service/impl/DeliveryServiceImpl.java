package dev.gihan.e_commerce.api.service.impl;

import dev.gihan.e_commerce.api.dto.requestDto.DeliveryRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.DeliveryResponseDto;
import dev.gihan.e_commerce.api.model.Delivery;
import dev.gihan.e_commerce.api.model.Order;
import dev.gihan.e_commerce.api.repository.DeliveryRepository;
import dev.gihan.e_commerce.api.repository.OrderRepository;
import dev.gihan.e_commerce.api.service.DeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private DeliveryRepository deliveryRepo;
    private OrderRepository orderRepo;

    @Override
    public DeliveryResponseDto createOrUpdateDelivery(DeliveryRequestDto dto) {
        Order order = orderRepo.findById(dto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Delivery delivery = deliveryRepo.findByOrderId(dto.getOrderId())
                .orElse(new Delivery());

        delivery.setOrder(order);
        delivery.setAddress(dto.getAddress());
        delivery.setTrackingNumber(dto.getTrackingNumber());
        delivery.setStatus(dto.getStatus());
        delivery.setDeliveryDate(LocalDate.now());

        return mapToDto(deliveryRepo.save(delivery));
    }

    @Override
    public DeliveryResponseDto getDeliveryByOrder(Long orderId, String username) {
        Delivery delivery = deliveryRepo.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("Delivery not found"));

        if (!delivery.getOrder().getCustomer().getUsername().equals(username)) {
            throw new RuntimeException("Access denied to this delivery.");
        }

        return mapToDto(delivery);
    }

    private DeliveryResponseDto mapToDto(Delivery delivery) {
        DeliveryResponseDto dto = new DeliveryResponseDto();
        dto.setDeliveryId(delivery.getId());
        dto.setOrderId(delivery.getOrder().getId());
        dto.setAddress(delivery.getAddress());
        dto.setTrackingNumber(delivery.getTrackingNumber());
        dto.setStatus(delivery.getStatus());
        dto.setDeliveryDate(delivery.getDeliveryDate());
        return dto;
    }
}
