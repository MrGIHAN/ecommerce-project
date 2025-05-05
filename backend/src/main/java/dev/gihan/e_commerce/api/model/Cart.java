package dev.gihan.e_commerce.api.entity;

import dev.gihan.e_commerce.api.model.CartItem;
import dev.gihan.e_commerce.api.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();

    public BigDecimal getTotal() {
            return cartItems.stream()
                    .map(item -> BigDecimal.valueOf(item.getProduct().getPrice()).multiply(BigDecimal.valueOf(item.getQuantity())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
}