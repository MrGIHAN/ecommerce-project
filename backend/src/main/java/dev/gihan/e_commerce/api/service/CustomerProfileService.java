package dev.gihan.e_commerce.api.service;

import dev.gihan.e_commerce.api.dto.requestDto.CustomerProfileRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.CustomerProfileResponseDto;
import dev.gihan.e_commerce.api.exception.NotFoundException;

public interface CustomerProfileService {

    void create ( CustomerProfileRequestDto customerProfileRequestDto);
    void update (Long id, CustomerProfileRequestDto customerProfileRequestDto)throws NotFoundException;
    void delete (Long id)throws NotFoundException;
    CustomerProfileResponseDto getById (Long id)throws NotFoundException;

}
