package dev.gihan.e_commerce.api.model;


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
    private LocalDate deliveryDate;

    @OneToOne
    private Order order;
}
