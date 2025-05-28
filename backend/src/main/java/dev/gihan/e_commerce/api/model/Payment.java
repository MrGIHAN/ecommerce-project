package dev.gihan.e_commerce.api.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "payments")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String method; // e.g., CARD, CASH
    private String transactionReference;
    private boolean successful;

    @OneToOne
    private Order order;
}

