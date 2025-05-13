package dev.gihan.e_commerce.api.service.impl;

import dev.gihan.e_commerce.api.dto.requestDto.CustomerProfileRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.AddressResponseDto;
import dev.gihan.e_commerce.api.dto.responseDto.CustomerProfileResponseDto;
import dev.gihan.e_commerce.api.exception.NotFoundException;
import dev.gihan.e_commerce.api.model.CustomerProfile;
import dev.gihan.e_commerce.api.repository.CustomerProfileRepository;
import dev.gihan.e_commerce.api.service.CustomerProfileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private CustomerProfileRepository customerProfileRepository;

    @Override
    public void create(CustomerProfileRequestDto customerProfileRequestDto) {
        CustomerProfile customerProfile = new CustomerProfile();

        // Set basic information
        customerProfile.setFirstName(customerProfileRequestDto.getFirstName());
        customerProfile.setLastName(customerProfileRequestDto.getLastName());
        customerProfile.setPhoneNumber(customerProfileRequestDto.getPhoneNumber());

        // Set addresses using helper methods from the DTO
        customerProfile.setDefaultShippingAddress(customerProfileRequestDto.getShippingAddress());
        customerProfile.setDefaultBillingAddress(customerProfileRequestDto.getBillingAddress());

        customerProfileRepository.save(customerProfile);
    }

    @Override
    public void update(Long id, CustomerProfileRequestDto customerProfileRequestDto) throws NotFoundException {

        CustomerProfile customerProfile = customerProfileRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Customer Profile Not Found" + id)
        );

        customerProfile.setFirstName(customerProfileRequestDto.getFirstName());
        customerProfile.setLastName(customerProfileRequestDto.getLastName());
        customerProfile.setPhoneNumber(customerProfileRequestDto.getPhoneNumber());

        customerProfile.setDefaultBillingAddress(customerProfileRequestDto.getBillingAddress());
        customerProfile.setDefaultShippingAddress(customerProfileRequestDto.getShippingAddress());

        customerProfileRepository.save(customerProfile);

    }

    @Override
    public void delete(Long id) throws NotFoundException {

        CustomerProfile customerProfile = customerProfileRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Customer Profile Not Found" + id)
        );
        customerProfileRepository.delete(customerProfile);
    }

    @Override
    public CustomerProfileResponseDto getById(Long id) throws NotFoundException {

        CustomerProfile customerProfile = customerProfileRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Customer Profile Not Found" + id)
        );

        return new CustomerProfileResponseDto(
                customerProfile.getId(),
                customerProfile.getUser().getId(),
                customerProfile.getFirstName(),
                customerProfile.getLastName(),
                customerProfile.getPhoneNumber(),
                AddressResponseDto.fromAddress(customerProfile.getDefaultShippingAddress()),
                AddressResponseDto.fromAddress(customerProfile.getDefaultBillingAddress())
        );
    }
}