package dev.gihan.e_commerce.api.dto.requestDto;

import dev.gihan.e_commerce.api.model.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerProfileRequestDto {

    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name cannot exceed 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name cannot exceed 50 characters")
    private String lastName;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+?[0-9\\s-]{10,15}$",
            message = "Invalid phone number format")
    private String phoneNumber;

    // Shipping Address
    @NotBlank(message = "Shipping street is required")
    private String shippingStreet;

    @NotBlank(message = "Shipping city is required")
    private String shippingCity;

    @NotBlank(message = "Shipping state is required")
    private String shippingState;

    @NotBlank(message = "Shipping ZIP code is required")
    private String shippingZipCode;

    @NotBlank(message = "Shipping country is required")
    private String shippingCountry;

    // Billing Address
    private boolean billingSameAsShipping = true;

    private String billingStreet;
    private String billingCity;
    private String billingState;
    private String billingZipCode;
    private String billingCountry;

    // Helper method to create a shipping address
    public Address getShippingAddress() {
        Address address = new Address();
        address.setStreet(shippingStreet);
        address.setCity(shippingCity);
        address.setState(shippingState);
        address.setZipCode(shippingZipCode);
        address.setCountry(shippingCountry);
        return address;
    }

    // Helper method to create a billing address
    public Address getBillingAddress() {
        if (billingSameAsShipping) {
            return getShippingAddress();
        }
        Address address = new Address();
        address.setStreet(billingStreet);
        address.setCity(billingCity);
        address.setState(billingState);
        address.setZipCode(billingZipCode);
        address.setCountry(billingCountry);
        return address;
    }
}