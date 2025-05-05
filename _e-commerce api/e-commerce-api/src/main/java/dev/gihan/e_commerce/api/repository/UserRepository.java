package dev.gihan.e_commerce.api.repository;

import dev.gihan.e_commerce.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserName(String username);

    boolean existsByUserEmail(String email);

}