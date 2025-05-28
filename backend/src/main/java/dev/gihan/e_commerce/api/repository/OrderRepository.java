package dev.gihan.e_commerce.api.repository;

import dev.gihan.e_commerce.api.model.Order;
import dev.gihan.e_commerce.api.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerId(Long customerId);

}

