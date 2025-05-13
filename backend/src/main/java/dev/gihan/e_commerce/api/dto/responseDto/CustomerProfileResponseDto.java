package dev.gihan.e_commerce.api.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerProfileResponseDto {

    private Long id;
    private Long userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private AddressResponseDto defaultShippingAddress;
    private AddressResponseDto defaultBillingAddress;

}