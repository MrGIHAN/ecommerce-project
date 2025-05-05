package dev.gihan.e_commerce.api.model;

import dev.gihan.e_commerce.api.model.option.PaymentMethod;
import dev.gihan.e_commerce.api.model.option.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PaymentMethod paymentMethod;
    private BigDecimal amount;
    private PaymentStatus status;
    private LocalDateTime paymentDate;
    private String transactionId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
