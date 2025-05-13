package dev.gihan.e_commerce.api.repository;

import dev.gihan.e_commerce.api.model.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Long> {
}
