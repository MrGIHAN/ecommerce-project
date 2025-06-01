package dev.gihan.e_commerce.api.model;


import dev.gihan.e_commerce.api.model.option.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "deliveries")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String trackingNumber;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    private LocalDate deliveryDate;

    @OneToOne
    private Order order;

}

