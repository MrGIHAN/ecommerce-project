package dev.gihan.e_commerce.api.dto.responseDto;

import dev.gihan.e_commerce.api.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressResponseDto {

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public static AddressResponseDto fromAddress(Address address) {
        if (address == null) return null;
        return new AddressResponseDto(
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZipCode(),
                address.getCountry()
        );
    }


}
