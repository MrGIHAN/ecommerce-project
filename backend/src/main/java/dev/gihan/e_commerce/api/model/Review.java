package dev.gihan.e_commerce.api.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "reviews")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rating; // 1–5
    private String comment;

    @ManyToOne
    private User customer;

    @ManyToOne
    private Product product;

}

