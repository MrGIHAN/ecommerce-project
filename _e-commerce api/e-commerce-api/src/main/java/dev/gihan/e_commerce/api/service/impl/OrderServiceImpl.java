package dev.gihan.e_commerce.api.service.impl;

import dev.gihan.e_commerce.api.repository.OrderRepository;
import dev.gihan.e_commerce.api.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Override
    public void create(Long id) {

    }
}
