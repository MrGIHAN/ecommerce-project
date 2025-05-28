package dev.gihan.e_commerce.api.service.impl;

import dev.gihan.e_commerce.api.dto.requestDto.OrderCreateRequestDto;
import dev.gihan.e_commerce.api.dto.requestDto.OrderItemRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.OrderItemDto;
import dev.gihan.e_commerce.api.dto.responseDto.OrderResponseDto;
import dev.gihan.e_commerce.api.exception.OrderNotFoundException;
import dev.gihan.e_commerce.api.model.Order;
import dev.gihan.e_commerce.api.model.OrderItem;
import dev.gihan.e_commerce.api.model.Product;
import dev.gihan.e_commerce.api.model.User;
import dev.gihan.e_commerce.api.model.option.OrderStatus;
import dev.gihan.e_commerce.api.repository.OrderRepository;
import dev.gihan.e_commerce.api.repository.ProductRepository;
import dev.gihan.e_commerce.api.repository.UserRepository;
import dev.gihan.e_commerce.api.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepo;
    private ProductRepository productRepo;
    private UserRepository userRepo;

    @Override
    public OrderResponseDto createOrder(OrderCreateRequestDto dto, String username) {
        User customer = userRepo.findByUsername(username).orElseThrow();

        Order order = new Order();
        order.setCustomer(customer);
        order.setDiscount(dto.getDiscount());
        order.setStatus(OrderStatus.PENDING);

        List<OrderItem> items = dto.getItems().stream().map(i -> {
            Product product = productRepo.findById(i.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(i.getQuantity());
            item.setPriceAtPurchase(product.getPrice());
            item.setOrder(order);
            return item;
        }).toList();

        order.setItems(items);
        return mapToDto(orderRepo.save(order));
    }

    @Override
    public List<OrderResponseDto> getMyOrders(String username) {
        User customer = userRepo.findByUsername(username).orElseThrow();
        return orderRepo.findByCustomerId(customer.getId())
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public OrderResponseDto addItemsToOrder(Long orderId, List<OrderItemRequestDto> items, String username) throws OrderNotFoundException {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));

        if (!order.getCustomer().getUsername().equals(username) || order.isCancelled())
            throw new RuntimeException("Not allowed");

        for (OrderItemRequestDto dto : items) {
            Product product = productRepo.findById(dto.getProductId()).orElseThrow();
            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(product);
            item.setQuantity(dto.getQuantity());
            item.setPriceAtPurchase(product.getPrice());
            order.getItems().add(item);
        }

        return mapToDto(orderRepo.save(order));
    }

    @Override
    public void cancelOrder(Long orderId, String username) {
        Order order = orderRepo.findById(orderId).orElseThrow();
        if (!order.getCustomer().getUsername().equals(username))
            throw new RuntimeException("Unauthorized to cancel");
        order.setCancelled(true);
        orderRepo.save(order);
    }

    private OrderResponseDto mapToDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setOrderId(order.getId());
        dto.setDiscount(order.getDiscount());
        dto.setStatus(order.getStatus().name());
        dto.setCancelled(order.isCancelled());

        double total = order.getItems().stream()
                .mapToDouble(i -> i.getPriceAtPurchase() * i.getQuantity())
                .sum();

        dto.setTotal(total - order.getDiscount());

        dto.setItems(order.getItems().stream().map(i -> {
            OrderItemDto itemDto = new OrderItemDto();
            itemDto.setProductName(i.getProduct().getName());
            itemDto.setQuantity(i.getQuantity());
            itemDto.setPriceAtPurchase(i.getPriceAtPurchase());
            return itemDto;
        }).toList());

        return dto;
    }
}

