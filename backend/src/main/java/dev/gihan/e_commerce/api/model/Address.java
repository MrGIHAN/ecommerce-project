package dev.gihan.e_commerce.api.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

}
