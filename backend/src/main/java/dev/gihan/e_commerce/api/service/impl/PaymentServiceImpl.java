package dev.gihan.e_commerce.api.service.impl;

import dev.gihan.e_commerce.api.dto.requestDto.PaymentRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.PaymentResponseDto;
import dev.gihan.e_commerce.api.exception.PaymentAlreadyExistsException;
import dev.gihan.e_commerce.api.model.Order;
import dev.gihan.e_commerce.api.model.Payment;
import dev.gihan.e_commerce.api.model.option.OrderStatus;
import dev.gihan.e_commerce.api.repository.OrderRepository;
import dev.gihan.e_commerce.api.repository.PaymentRepository;
import dev.gihan.e_commerce.api.repository.UserRepository;
import dev.gihan.e_commerce.api.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepo;
    private OrderRepository orderRepo;
    private UserRepository userRepo;

    @Override
    public PaymentResponseDto makePayment(PaymentRequestDto dto, String username) throws PaymentAlreadyExistsException {
        Order order = orderRepo.findById(dto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (!order.getCustomer().getUsername().equals(username)) {
            throw new RuntimeException("You can only pay for your own orders.");
        }

        if (order.isCancelled()) {
            throw new RuntimeException("Cannot pay for a cancelled order.");
        }

        if (paymentRepo.findByOrderId(dto.getOrderId()).isPresent()) {
            throw new PaymentAlreadyExistsException("Payment already recorded for this order.");
        }

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setMethod(dto.getMethod());
        payment.setTransactionReference(dto.getTransactionReference());
        payment.setSuccessful(true); // Simulate success
        Payment saved = paymentRepo.save(payment);

        order.setStatus(OrderStatus.PAID); // ✅ Mark order as paid
        orderRepo.save(order);

        return mapToDto(saved);
    }

    @Override
    public PaymentResponseDto getPaymentForOrder(Long orderId, String username) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (!order.getCustomer().getUsername().equals(username)) {
            throw new RuntimeException("Access denied to this payment.");
        }

        Payment payment = paymentRepo.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("No payment found."));

        return mapToDto(payment);
    }

    private PaymentResponseDto mapToDto(Payment payment) {
        PaymentResponseDto dto = new PaymentResponseDto();
        dto.setPaymentId(payment.getId());
        dto.setMethod(payment.getMethod());
        dto.setTransactionReference(payment.getTransactionReference());
        dto.setSuccessful(payment.isSuccessful());
        dto.setOrderId(payment.getOrder().getId());
        return dto;
    }
}

