package dev.gihan.e_commerce.api.model;

import dev.gihan.e_commerce.api.model.option.DiscountType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String description;
    private BigDecimal discountAmount;
    private DiscountType discountType; // PERCENTAGE or FIXED_AMOUNT
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean active;

}
