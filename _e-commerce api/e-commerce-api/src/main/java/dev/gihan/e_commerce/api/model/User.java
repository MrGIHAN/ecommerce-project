package dev.gihan.e_commerce.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password; // Should be encrypted
    private String roles; // "ROLE_USER,ROLE_ADMIN"

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private CustomerProfile customerProfile;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

}
