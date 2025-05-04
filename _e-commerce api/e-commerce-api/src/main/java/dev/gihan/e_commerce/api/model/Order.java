package dev.gihan.e_commerce.api.model;

import dev.gihan.e_commerce.api.model.option.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String orderNumber; // Unique identifier like "ORD-20240503-0001"

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    private LocalDateTime orderDate;
    private OrderStatus status;

    @Embedded
    private Address shippingAddress;

    @Embedded
    private Address billingAddress;

    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal shippingFee;
    private BigDecimal total;

    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

    @PrePersist
    public void calculateTotals() {
        this.subtotal = calculateSubtotal();
        this.total = subtotal.add(tax).add(shippingFee);
    }

    private BigDecimal calculateSubtotal() {
        return items.stream()
                .map(item -> item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
