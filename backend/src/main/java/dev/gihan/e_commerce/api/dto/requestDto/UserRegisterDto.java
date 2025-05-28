package dev.gihan.e_commerce.api.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRegisterDto {
    private String username;
    private String email;
    private String password;
    private String role; // "CUSTOMER" or "SELLER"
}

