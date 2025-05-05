package dev.gihan.e_commerce.api.repository;

import dev.gihan.e_commerce.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
