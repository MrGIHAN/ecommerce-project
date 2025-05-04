package dev.gihan.e_commerce.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CustomerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    @Embedded
    private Address defaultShippingAddress;

    @Embedded
    private Address defaultBillingAddress;
}

