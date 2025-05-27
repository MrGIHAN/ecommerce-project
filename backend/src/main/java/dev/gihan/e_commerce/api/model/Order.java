package dev.gihan.e_commerce.api.model;
import dev.gihan.e_commerce.api.model.option.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "`order`")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isCancelled = false;

    @ManyToOne
    private User customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    private double discount;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
